package com.example.pratyush.learningjunction;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.pratyush.learningjunction.MyNotes.DBAdapter;
import com.example.pratyush.learningjunction.MyNotes.MyAdapter;
import com.example.pratyush.learningjunction.MyNotes.TaskList;

import java.util.ArrayList;

public class Fragment_Mynotes extends Fragment {
    EditText title, description;
    FloatingActionButton fab;
    RecyclerView rv;
    MyAdapter adapter;
    ArrayList<TaskList> taskLists=new ArrayList<>();

     @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mynotes,container,false);
        fab=view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog d = new Dialog(getActivity());
                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.setContentView(R.layout.layout_custom_dialog);
                title = d.findViewById(R.id.title);
                description = d.findViewById(R.id.description);
                final Button save = d.findViewById(R.id.save);
                final Button retrieve = d.findViewById(R.id.retrieve);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        save(title.getText().toString(), description.getText().toString());
                        d.dismiss();
                    }
                });
                retrieve.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        retrieve();
                    }
                });
                d.show();
            }
        });
         //Recycler setting
         rv=view.findViewById(R.id.recyclerView);
         rv.setHasFixedSize(true);
         rv.setLayoutManager(new LinearLayoutManager(getActivity()));
//        rv.setItemAnimator(new DefaultItemAnimator());

         //Adapter setting
         adapter=new MyAdapter(getActivity(),taskLists);
         retrieve();
        return view;
    }
    private void save(String stitle, String sdescription){
        DBAdapter db=new DBAdapter(getActivity());
        //open the database
        db.openDB();
        //commit
        long result=db.add(stitle,sdescription);
        if (result>0){
            title.setText("");
            description.setText("");
        }
        else{
            Snackbar.make(title,"Unable to save data", Snackbar.LENGTH_SHORT).show();
        }
        db.closeDB();
        //ReFresh
        retrieve();
    }
    private void retrieve() {
        taskLists.clear();
        DBAdapter db = new DBAdapter(getActivity());
        db.openDB();
        Cursor c = db.getAllTask();
        //Loop and add to arraylist
        while (c.moveToNext()) {
            int id = c.getInt(0);
            String title = c.getString(1);
            String description = c.getString(2);
            TaskList t = new TaskList(id, title, description);
            //Add to arraylist
//            taskLists.add(new Integer(2));
            taskLists.add(t);
        }
        if (!(taskLists.size()<1)){
            rv.setAdapter(adapter);
        }
        db.closeDB();
    }
}