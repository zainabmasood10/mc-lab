package com.example.finalexam191184;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmenthobby#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fraghobby extends Fragment {

    FirebaseAuth mAthu;
    DatabaseReference ref;



    public fraghobby() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fraghobby, container, false);

        mAthu = FirebaseAuth.getInstance();
        String uid = mAthu.getCurrentUser().getUid();

        ref = FirebaseDatabase.getInstance().getReference("Data");
        ref.child(uid).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {

                if(task.isSuccessful()){
                    Map<String, Object> map = (Map<String, Object>) task.getResult();

                    Toast.makeText(getContext(),map.get("hobbies").toString(),Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        ArrayList<fragmodel> hooby = new ArrayList<>();

        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Cricket", "Good for health"));
        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Football", "Good for legs"));
        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Reading", "Skills"));
        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Singing", "love"));
        hooby.add(new fragmodel(R.mipmap.ic_launcher, "Outing", "Enjoyment"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new fargadapter(hooby));
        return view;

    }
}