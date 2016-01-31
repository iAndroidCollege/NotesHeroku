package adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import controllers.AllNotesFragment;
import controllers.InsertNoteFragment;

public class NotesFragemntAdapter extends FragmentStatePagerAdapter {

    public NotesFragemntAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new InsertNoteFragment();
            case 1:return new AllNotesFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Insert Note";
            case 1:return "Read Notes";
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
