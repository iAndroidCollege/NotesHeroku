package controllers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import college.edu.tomer.notesheroku.R;
import dbaccess.DAO;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsertNoteFragment extends Fragment {


    @Bind(R.id.etTitle)
    EditText etTitle;
    @Bind(R.id.etNote)
    EditText etNote;
    @Bind(R.id.btnSave)
    Button btnSave;

    public InsertNoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_note, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnSave)
    void save(){
        String title = etTitle.getText().toString();
        String note = etNote.getText().toString();
        DAO d = DAO.getSharedInstance(getActivity());
        d.createNote(title, note);
        ((MainActivity)getActivity()).refresh();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
