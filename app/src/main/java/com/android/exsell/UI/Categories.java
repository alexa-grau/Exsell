package com.android.exsell.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.android.exsell.R;
import com.android.exsell.adapters.CategoryAdapter;
import com.android.exsell.models.Category;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Categories extends AppCompatActivity {

    LinearLayout layoutTop, layoutBottom;
    DrawerLayout drawer;
    NavigationView navigationView;
    public static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView categoryRecycler;
    private static ArrayList<Category> categoryNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_categories);
        layoutTop = findViewById(R.id.layoutTopBar);
        layoutBottom = findViewById(R.id.layoutBottomBar);
        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationMenu);

        layoutTop.findViewById(R.id.searchButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Categories.this, SearchBar.class));
            }
        });
        layoutBottom.findViewById(R.id.wishlistButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Categories.this, WishlistActivity.class));
            }
        });
        layoutTop.findViewById(R.id.leftNavigationButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        loadProducts();
        categoryRecycler = findViewById(R.id.recyclerViewCategoryTiles);
        loadRecycler(categoryRecycler, categoryNames);
        adapter = new CategoryAdapter(categoryNames);
        categoryRecycler.setAdapter(adapter);
    }
    public void loadProducts() {
        String[] fakeTags = {"Textbooks", "COEN"};
        Category catergory1 = new Category(1, "Category 1", R.drawable.test_image);
        Category catergory2 = new Category(2, "Category 2", R.drawable.test_image);
        Category catergory3 = new Category(3, "Category 3", R.drawable.test_image);
        Category catergory4 = new Category(4, "Category 4", R.drawable.test_image);
        // add to arraylists
        categoryNames = new ArrayList<Category>();
        categoryNames.add(catergory1);
        categoryNames.add(catergory2);
        categoryNames.add(catergory3);
        categoryNames.add(catergory4);

    }
    public void loadRecycler(RecyclerView thisRecycler, ArrayList<Category> cat){
        layoutManager = new GridLayoutManager(this, 2);
        thisRecycler.setHasFixedSize(true); // set has fixed size
        thisRecycler.setLayoutManager(layoutManager); // set layout manager

        // create and set adapter
        adapter = new CategoryAdapter(cat);
        thisRecycler.setAdapter(adapter);
    }

}