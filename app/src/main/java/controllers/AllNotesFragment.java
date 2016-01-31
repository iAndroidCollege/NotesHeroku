package controllers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import adapters.NotesRecyclerViewAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import college.edu.tomer.notesheroku.R;
import dbaccess.DAO;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllNotesFragment extends Fragment {


    @Bind(R.id.rvNotes)
    RecyclerView rvNotes;

    public AllNotesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "Returned", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_notes, container, false);
        ButterKnife.bind(this, view);

        rvNotes.setLayoutManager(new LinearLayoutManager(getActivity()));
        NotesRecyclerViewAdapter adapter = new NotesRecyclerViewAdapter(
                DAO.getSharedInstance(getActivity()).readAllNotes(),
                getActivity());

        rvNotes.setAdapter(adapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
