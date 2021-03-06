//package features;
//
//import java.util.Locale;
//
//import android.R;
//import android.app.Activity;
//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.SearchManager;
//import android.content.Intent;
//import android.content.res.Configuration;
//import android.os.Bundle;
//import android.support.v4.app.ActionBarDrawerToggle;
//import android.support.v4.view.GravityCompat;
//import android.support.v4.widget.DrawerLayout;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.Toast;
//
//@SuppressWarnings("deprecation")
//public class SideMenu extends Activity {
//	private DrawerLayout mDrawerLayout;
//    private ListView mDrawerList;
//    private ActionBarDrawerToggle mDrawerToggle;
//
//    private CharSequence mDrawerTitle;
//    private CharSequence mTitle;
//    private String[] mPlanetTitles;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout);
//
//        mTitle = mDrawerTitle = getTitle();
//        mPlanetTitles = getResources().getStringArray(R.array.a);
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mDrawerList = (ListView) findViewById(R.id.left_drawer);
//
//        // set a custom shadow that overlays the main content when the drawer opens
//        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
//        // set up the drawer's list view with items and click listener
//        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
//                R.layout.drawer_list_item, mPlanetTitles));
//        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
//
//        // enable ActionBar app icon to behave as action to toggle nav drawer
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setHomeButtonEnabled(true);
//
//        // ActionBarDrawerToggle ties together the the proper interactions
//        // between the sliding drawer and the action bar app icon
//        mDrawerToggle = new ActionBarDrawerToggle(
//                this,                  /* host Activity */
//                mDrawerLayout,         /* DrawerLayout object */
//                R.drawable.ic_dialog_alert,  /* nav drawer image to replace 'Up' caret */
//                R.string.copy,  /* "open drawer" description for accessibility */
//                R.string.copy  /* "close drawer" description for accessibility */
//                ) {
//            public void onDrawerClosed(View view) {
//                getActionBar().setTitle(mTitle);
//                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
//            }
//
//            public void onDrawerOpened(View drawerView) {
//                getActionBar().setTitle(mDrawerTitle);
//                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
//            }
//        };
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
//
//        if (savedInstanceState == null) {
//            selectItem(0);
//        }
//    }
//
//    
//    
//    
//    
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//   
//
//   
//
//    /* The click listner for ListView in the navigation drawer */
//    private class DrawerItemClickListener implements ListView.OnItemClickListener {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            selectItem(position);
//        }
//    }
//
//    private void selectItem(int position) {
//        // update the main content by replacing fragments
//        Fragment fragment = new PlanetFragment();
//        Bundle args = new Bundle();
//        args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
//        fragment.setArguments(args);
//
//        FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
//
//        // update selected item and title, then close the drawer
//        mDrawerList.setItemChecked(position, true);
//        setTitle(mPlanetTitles[position]);
//        mDrawerLayout.closeDrawer(mDrawerList);
//    }
//
//    @Override
//    public void setTitle(CharSequence title) {
//        mTitle = title;
//        getActionBar().setTitle(mTitle);
//    }
//
//    /**
//     * When using the ActionBarDrawerToggle, you must call it during
//     * onPostCreate() and onConfigurationChanged()...
//     */
//
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        // Sync the toggle state after onRestoreInstanceState has occurred.
//        mDrawerToggle.syncState();
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        // Pass any configuration change to the drawer toggls
//        mDrawerToggle.onConfigurationChanged(newConfig);
//    }
//
//    /**
//     * Fragment that appears in the "content_frame", shows a planet
//     */
//    public static class PlanetFragment extends Fragment {
//        public static final String ARG_PLANET_NUMBER = "planet_number";
//
//        public PlanetFragment() {
//            // Empty constructor required for fragment subclasses
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.activity_list_item, container, false);
//            int i = getArguments().getInt(ARG_PLANET_NUMBER);
////            String planet = getResources().getStringArray(R.array.viewsArray)[i];
////
////            int imageId = getResources().getIdentifier(planet.toLowerCase(Locale.getDefault()),
////                            "drawable", getActivity().getPackageName());
////            ((ImageView) rootView.findViewById(R.id.icon1)).setImageResource(imageId);
////            getActivity().setTitle(planet);
//            return rootView;
//        }
//    }
//}
