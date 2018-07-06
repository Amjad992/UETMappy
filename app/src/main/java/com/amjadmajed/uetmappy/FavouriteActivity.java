package com.amjadmajed.uetmappy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FavouriteActivity extends AppCompatActivity {

    int savingLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);


        String[] placeName = {
                  "Administration Block"
                , "Ali Mardan Hall"
                , "Al-Khwarizmi Institute"
                , "Anexxe Canteen"
                , "Automotive Center"
                , "Ayesha Hall"
                , "Basketball Court"
                , "Chemical Department Seminar Hall"
                , "Chemical Engineering Department"
                , "City and Regional Planning Department"
                , "Civil Engineering Department"
                , "Computer Science and Engineering Department"
                , "Department of Architecture Engineering and Design"
                , "Electrical Engineering Department"
                , "Faculty Colony"
                , "Faculty of Architecture and Planning"
                , "Football Stadium"
                , "Gate Number 0"
                , "Gate Number 1"
                , "Gate Number 2"
                , "Gate Number 3"
                , "Gate Number 4"
                , "Gate Number 5"
                , "Gate Number 6"
                , "Geological Engineering Department"
                , "Girl's Service Center"
                , "Habib Bank"
                , "HBL Library ATM"
                , "HBL SSC ATM"
                , "Health Clinic"
                , "Huawei UET Joint Telecom IT Centre"
                , "Humanities Management and Social Sciences Department"
                , "IB&M"
                , "Institute of Environmental Engineering and Research "
                , "Iqbal Hall Canteen"
                , "Iqbal Hall"
                , "Islamiat Department"
                , "Khadija Hall"
                , "Khalid Hall"
                , "Lalazar Extension"
                , "Lalazar"
                , "Main Auditorium"
                , "Main Block"
                , "Mathmatics Department"
                , "MCB ATM"
                , "Mechanical Engineering Department"
                , "Mechatronics and Control Engineering Department"
                , "Mining Engineering"
                , "Muhammad Bin Qasim Hall"
                , "Mumtaz Hall Canteen"
                , "Mumtaz Hall"
                , "National Library of Engineering Science"
                , "National Science Museum"
                , "New Boys Hostel"
                , "New Lecture Theatre"
                , "Old Auditorium"
                , "Omer Hall"
                , "Optronics Center"
                , "Osama General Store"
                , "Petroleum and Gas Engineering Department"
                , "Physics Department"
                , "Post Office"
                , "Product and Industrial Design"
                , "Quid-e-Azam Hall"
                , "Research Center"
                , "Sharqi Gate"
                , "Shopping Center"
                , "Sir Syed Hall"
                , "Software Engineering Center"
                , "Sport Complex"
                , "Sports Cafeteria"
                , "Staff Club"
                , "Staff Colony"
                , "Star Photocopy Shop"
                , "Student Service Center"
                , "Sultan Mehmood Ghaznavi Hall"
                , "Swimming Pool"
                , "Tennis Court"
                , "Transportation Engineering and Managment Department"
                , "UET Bus Stand"
                , "UET Stadium"
                , "United Cafeteria"
                , "University Mosque"
                , "Usman Hall"
                , "Visiting Faculty Hostel"
                , "Workshop"
                , "Zubair Hall"
        };


        // Get ListView object from xml
        final ListView listView = (ListView) findViewById(R.id.fav_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,placeName);
        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item name
                String itemValue = (String) listView.getItemAtPosition(position);

                // Intent
                Intent i = new Intent(FavouriteActivity.this, NavigationActivity.class);
                i.putExtra("placeToShow", itemValue);
                startActivity(i);
            }


        });
    }
}
