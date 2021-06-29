package com.example.finalexam191184;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Hobby1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fraghobby1 extends Fragment {



    public fraghobby1() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fraghobby, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        ArrayList<fragmodel> hooby = new ArrayList<>();

        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Makeup", "Good for health"));
        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Playing", "Good for legs"));
        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Styling", "Skills"));
        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Singing", "love"));
        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Outing", "Enjoyment"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new fargadapter(hooby));
        return view;

    }
}