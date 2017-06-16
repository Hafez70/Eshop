package com.hzdroid.ir.eshop.activitie;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.hzdroid.ir.eshop.R;
import fragments.fragment_categories;
import fragments.fragment_main;
import fragments.fragment_profile;
import fragments.fragment_shopping_cart;
import fragments.fragment_wishlist;

public class MainActivity extends AppCompatActivity implements
        fragment_categories.OncategoriesFragmentInteractionListener,
        fragment_main.OnmainFragmentInteractionListener,
        fragment_wishlist.OnwishlistFragmentInteractionListener,
        fragment_shopping_cart.OnshoppingcartFragmentInteractionListener,
        fragment_profile.OnprofileFragmentInteractionListener
{

    private TextView mTextMessage;

     Fragment fragment;
     FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // action bar section
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.actionbar_main_menu);
        // action bar section

        // Bottom navigation view section
        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        AHBottomNavigationItem itemHome = new AHBottomNavigationItem("پلاک 9",R.drawable.ic_home_black_70dp);
        AHBottomNavigationItem itemCategory = new AHBottomNavigationItem("کتگوری",R.drawable.ic_categories_black_70dp);
        AHBottomNavigationItem itemShopCart = new AHBottomNavigationItem("سبد خرید",R.drawable.ic_shopping_cart_black_70dp);
        AHBottomNavigationItem itemWithList = new AHBottomNavigationItem("لیست علاقه",R.drawable.ic_favorite_black_70dp);
        AHBottomNavigationItem itemProfile = new AHBottomNavigationItem("پروفایل",R.drawable.ic_person_black_70dp);

        bottomNavigation.addItem(itemHome);
        bottomNavigation.addItem(itemCategory);
        bottomNavigation.addItem(itemShopCart);
        bottomNavigation.addItem(itemWithList);
        bottomNavigation.addItem(itemProfile);
        // Bottom navigation view section
        fragmentManager = getSupportFragmentManager();
        fragment = fragment_main.newInstance(String.valueOf("ad"),String.valueOf("ad"));
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content, fragment).commit();

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                switch (position){
                    case 0:
                        fragment = fragment_main.newInstance(String.valueOf("ad"),String.valueOf("ad"));
                        break;
                    case 1:
                        fragment = fragment_categories.newInstance(String.valueOf("ad"),String.valueOf("ad"));
                        break;
                    case 2:
                        fragment = fragment_shopping_cart.newInstance(String.valueOf("ad"),String.valueOf("ad"));
                        break;
                    case 3:
                        fragment = fragment_wishlist.newInstance(String.valueOf("ad"),String.valueOf("ad"));
                        break;
                    case 4:
                        fragment = fragment_profile.newInstance(String.valueOf("ad"),String.valueOf("ad"));
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.content, fragment).commit();
                return true;
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri){

    }
}
