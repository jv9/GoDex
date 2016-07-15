package godex.godexapp;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.lapism.searchview.SearchView;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabClickListener;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    //private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private BottomBar mBottomBar;
    private SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //mSearchView = (SearchView) findViewById(R.id.searchView);



        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItems(
                new BottomBarTab(android.R.drawable.arrow_down_float, "Fuck you"),
                new BottomBarTab(android.R.drawable.arrow_up_float, "Brandon")
        );

        final LayoutInflater inflater = this.getLayoutInflater();

        PlaceholderFragment frag = new PlaceholderFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, frag).commit();


        // Listen for tab changes
        mBottomBar.setOnTabClickListener(new OnTabClickListener() {
            View view = inflater.inflate(R.layout.fragment_main, null, false);



            @Override
            public void onTabSelected(int position) {
                // The user selected a tab at the specified position
  //              TextView tex = (TextView) findViewById(R.id.section_label);
//                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                if(position == 1) {
                    Log.d("Things", "tab 1");

//                    tex.setText("");
                    //set the Fragment to page1.xml
                    PlaceholderFragment frag = new PlaceholderFragment();
                    pageNum = 1;

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, frag).commit();

                }
                else if(position == 0) {
                    Log.d("Things", "tab 2");

                    pageNum = 0;
                    //set the Fragment to page2.xml
                    PlaceholderFragment frag = new PlaceholderFragment();

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, frag).commit();

                }

            }

            @Override
            public void onTabReSelected(int position) {
                // The user reselected a tab at the specified position!
            }
        });


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
  //      setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
 //       mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
  //      mViewPager = (ViewPager) findViewById(R.id.container);
    //    mViewPager.setAdapter(mSectionsPagerAdapter);

  //      TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(mViewPager);

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_info) {
//            return true;
//        }
//        if(id == R.id.searchView) {
//            mSearchView.animate(); // animate, ONLY FOR MENU ITEM
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
    static int pageNum;

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {

        }


        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();

            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);

            pageNum = sectionNumber;

            return fragment;

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = null;

            //page changing
            if(pageNum == 0)
                rootView= inflater.inflate(R.layout.page1, container, false);
            else if (pageNum == 1) {
                rootView= inflater.inflate(R.layout.page2, container, false);
            }

            Log.d("Error", "Frag made "+pageNum);

            return rootView;


        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
//    public class SectionsPagerAdapter extends FragmentPagerAdapter {
//
//        public SectionsPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            // getItem is called to instantiate the fragment for the given page.
//            // Return a PlaceholderFragment (defined as a static inner class below).
//            return PlaceholderFragment.newInstance(position + 1);
//        }
//
//        @Override
//        public int getCount() {
//            // Show 3 total pages.
//            return 2;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case 0:
//                    return "Fuck";
//                case 1:
//                    return "You";
//
//            }
//            return null;
//        }
//    }
}
