package com.example.kaitpicco.puzzleapplication;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A placeholder fragment containing a simple view.
 */
public class PeopleFragment extends Fragment {
    private String Jsonstr = null;
    private TableLayout tl;

    public PeopleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_people, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setBackgroundDrawableResource(R.drawable.wallpaper);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tl=(TableLayout)getActivity().findViewById(R.id.table);
        tl.setColumnStretchable(0, true);
        tl.setColumnStretchable(1, true);

        FetchData fetchData=new FetchData();
        fetchData.execute();


    }

    private void extractData() {
        String[] firstname=new String[30];
        String[] lastname=new String[30];
        try {
            JSONObject Jsonobj = new JSONObject(Jsonstr);
            JSONArray jsonArray = Jsonobj.getJSONArray("people");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject dayForecast = jsonArray.getJSONObject(i);
                firstname[i]=dayForecast.getString("first_name");
                lastname[i]=dayForecast.getString("last_name");
                TableRow tr = new TableRow(getActivity());
                TextView textView1=new TextView(getActivity());
                TextView textView2=new TextView(getActivity());
                if(!firstname[i].equals("null"))
                textView1.setText(firstname[i]);
                if(!lastname[i].equals("null"))
                textView2.setText(lastname[i]);
                textView1.setTextSize(20);
                textView1.setGravity(Gravity.CENTER);
                textView1.setTextColor(Color.WHITE);
                textView2.setTextSize(20);
                textView2.setGravity(Gravity.CENTER);
                textView2.setTextColor(Color.WHITE);
                Log.v("People", firstname[i]);
                tr.addView(textView1);
                tr.addView(textView2);
                tr.setPadding(10, 10, 10, 10);
                tl.addView(tr);

                Log.v("People Fragment->Data", dayForecast.toString());
           }
        } catch (Exception e) {
            Log.v("People Fragment", "Couldn't Parse", e);
        }
    }

    public class FetchData extends AsyncTask<Void,Void,Void>{

        private final ProgressDialog dialog = new ProgressDialog(getActivity());
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

                this.dialog.setMessage("Please wait");
                this.dialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL("https://api.myjson.com/bins/4i6jm");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
            }catch(Exception e){Log.v("People Fragment", "Do you have internet connection?");
                }
            try{
                InputStream inputStream = urlConnection != null ? urlConnection.getInputStream() : null;
                StringBuilder buffer = new StringBuilder();
                if (inputStream == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line).append("\n");
                }
                Log.v("PeopleFragment",buffer.toString());

                if (buffer.length() == 0) {
                    return null;
                }
                Jsonstr = buffer.toString();
            }catch(Exception e){
                Log.v("PeopleFragment", "Error fetching data", e);}
            finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                        Log.e("PeopleFragment", "Error closing stream", e);
                    }
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            this.dialog.dismiss();
            if(Jsonstr==(null))
                Toast.makeText(getActivity(),"Do you have an active internet connection?",Toast.LENGTH_SHORT).show();
            extractData();
        }
    }


}
