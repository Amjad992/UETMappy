package com.amjadmajed.uetmappy;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NavigationActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, GoogleMap.OnMapLongClickListener, Serializable {


    Button mBtnFind;
    Button bNavigation;
    AutoCompleteTextView etPlace;
    MarkerOptions markerOptions;
    GoogleMap.OnCameraChangeListener listener;
    Location myLocation;
    LatLng navOrig;
    LatLng navDest;
    LatLng uet = new LatLng(31.579339, 74.355142);
    LatLng CornerOne = new LatLng(31.576110, 74.351375);
    LatLng CornerTwo = new LatLng(31.584762, 74.361735);

    String placeToShow;
    int numberOfPlaces = 87;
    String[] placeName = {
            "administration block"
            , "ali mardan hall"
            , "al-khwarizmi institute"
            , "anexxe canteen"
            , "automotive center"
            , "ayesha hall"
            , "basketball court"
            , "chemical department seminar hall"
            , "chemical engineering department"
            , "city and regional planning department"
            , "civil engineering department"
            , "computer science and engineering department"
            , "department of architecture engineering and design"
            , "electrical engineering"
            , "faculty colony"
            , "faculty of architecture and planning"
            , "football stadium"
            , "gate number 0"
            , "gate number 1"
            , "gate number 2"
            , "gate number 3"
            , "gate number 4"
            , "gate number 5"
            , "gate number 6"
            , "geological engineering department"
            , "girl's service center"
            , "habib bank"
            , "hbl library atm"
            , "hbl ssc atm"
            , "health clinic"
            , "huawei center"
            , "humanities management and social sciences department"
            , "ib&m"
            , "institute of environmental engineering and reasearch"
            , "iqbal hall canteen"
            , "iqbal hall"
            , "islamiat department"
            , "khadija hall"
            , "khalid hall"
            , "lalazar extension"
            , "lalazar"
            , "main auditorium"
            , "main block"
            , "mathematics department"
            , "mcb atm"
            , "mechanical engineering department"
            , "mechatronics and control engineering department"
            , "mining engineering"
            , "muhammad bin qasim hall"
            , "mumtaz hall canteen"
            , "mumtaz hall"
            , "national library of engineering sciences"
            , "national science museum"
            , "new boys hostel"
            , "new lecture theatres"
            , "old auditorium"
            , "omer hall"
            , "optronics center"
            , "osama general store"
            , "petroleum and gas engineering department"
            , "physics department"
            , "post office"
            , "product and industrial design department"
            , "quid-e-azam hall"
            , "research center"
            , "sharqi gate"
            , "shopping center"
            , "sir syed hall"
            , "software engineering canter"
            , "sports complex"
            , "sports cafeteria"
            , "staff club"
            , "staff colony"
            , "star photocopy shop"
            , "student service center"
            , "sultan mehmood ghaznavi hall"
            , "swimming pool"
            , "tennis courts"
            , "transportation engineering and managment department"
            , "uet bus stand"
            , "uet stadium"
            , "united cafeteria"
            , "university mosque"
            , "usman hall"
            , "visiting faculty hostel"
            , "workshop"
            , "zubair hall"
    };

    String[] placeCommonName = {
            "admin block"
            , "ali mardan hall"
            , "kics"
            , "anexxe"
            , "automotive"
            , "ayesha hall"
            , "basketball"
            , "chemical seminar hall"
            , "chemical"
            , "crp"
            , "civil"
            , "cse"
            , "architecture"
            , "electrial"
            , "faculty colony"
            , "architecture"
            , "football ground"
            , "gate 0"
            , "gate 1"
            , "gate 2"
            , "gate 3"
            , "gate 4"
            , "gate 5"
            , "gate 6"
            , "geological"
            , "gssc"
            , "hbl"
            , "hbl atm 2"
            , "hbl atm 1"
            , "dispensary"
            , "huawei"
            , "comm skills"
            , "ibm"
            , "environmental"
            , "iqbal canteen"
            , "iqbal zoo"
            , "islamiat"
            , "khadija hall"
            , "khalid"
            , "extension"
            , "lalazar"
            , "auditorium"
            , "main block"
            , "math department"
            , "mcb atm"
            , "mechanical"
            , "mechatronics"
            , "mining"
            , "mbq hall"
            , "mumtaz canteen"
            , "mumtaz hall"
            , "library"
            , "museum"
            , "NBH"
            , "lecture theatres"
            , "old auditorium"
            , "omer hall"
            , "optronics"
            , "osama store"
            , "petroleum"
            , "physics"
            , "post office"
            , "pid"
            , "q hall"
            , "research center"
            , "sharqi"
            , "shopping center"
            , "sirsyed hall"
            , "se center"
            , "complex"
            , "sports cafe"
            , "staff club"
            , "staff colony"
            , "star photocopy"
            , "ssc"
            , "ghanznavi hall"
            , "swimming"
            , "tennis"
            , "transport"
            , "bus stand"
            , "stadium"
            , "uc"
            , "masjid"
            , "usman hall"
            , "faculty hostel"
            , "wood workshop"
            , "z hall"
    };

    String[] tags = {
            "office"
            , "hostel"
            , "center"
            , "food"
            , "center"
            , "hostel"
            , "sport"
            , "event"
            , "department"
            , "department"
            , "department"
            , "department"
            , "department"
            , "department"
            , "house"
            , "department"
            , "sport"
            , "gate"
            , "gate"
            , "gate"
            , "gate"
            , "gate"
            , "gate"
            , "gate"
            , "department"
            , "food"
            , "bank"
            , "atm"
            , "atm"
            , "health"
            , "center"
            , "department"
            , "department"
            , "department"
            , "food"
            , "hostel"
            , "department"
            , "hostel"
            , "hostel"
            , "food"
            , "food"
            , "events"
            , "lecture hall"
            , "department"
            , "atm"
            , "department"
            , "department"
            , "department"
            , "hostel"
            , "food"
            , "hostel"
            , "library"
            , "museum"
            , "hostel"
            , "lecture theatres"
            , "event"
            , "hostel"
            , "center"
            , "store"
            , "department"
            , "department"
            , "office"
            , "department"
            , "hostel"
            , "center"
            , "gate"
            , "store"
            , "hostel"
            , "lecture hall"
            , "sport"
            , "food"
            , "house"
            , "house"
            , "photocopy"
            , "food"
            , "hostel"
            , "sport"
            , "sport"
            , "department"
            , "bus stand"
            , "sport"
            , "food"
            , "pray"
            , "hostel"
            , "hostel"
            , "lecture hall"
            , "hostel"
    };
    Float[] placeLat = {
            31.576876f
            , 31.578315f
            , 31.578123f
            , 31.577346f
            , 31.577492f
            , 31.578789f
            , 31.581709f
            , 31.580287f
            , 31.579781f
            , 31.578923f
            , 31.578944f
            , 31.578552f
            , 31.577870f
            , 31.577388f
            , 31.580947f
            , 31.579054f
            , 31.579940f
            , 31.576207f // gates 0
            , 31.576495f // gates 1
            , 31.576743f // gates 2
            , 31.576925f // gates 3
            , 31.577108f // gates 4
            , 31.577355f // gates 5
            , 31.577543f // gates 6
            , 31.580148f
            , 31.579162f
            , 31.576668f
            , 31.578765f
            , 31.578675f
            , 31.582257f
            , 31.577521f
            , 31.577152f
            , 31.578453f
            , 31.577460f
            , 31.581624f // iqbal hall canteen
            , 31.582038f
            , 31.577986f
            , 31.579216f
            , 31.578506f
            , 31.578934f
            , 31.578107f
            , 31.578462f
            , 31.577972f
            , 31.578494f
            , 31.578420f
            , 31.577769f
            , 31.577368f
            , 31.580185f
            , 31.579251f
            , 31.580150f // mumtaz hall canteen
            , 31.580797f
            , 31.578638f
            , 31.576873f
            , 31.579277f
            , 31.578477f
            , 31.581194f
            , 31.578769f
            , 31.577511f
            , 31.579114f
            , 31.580183f
            , 31.578010f
            , 31.579747f
            , 31.577490f
            , 31.581406f
            , 31.577165f
            , 31.583482f // sharqi gate
            , 31.579769f
            , 31.581992f
            , 31.578487f
            , 31.581143f
            , 31.580561f
            , 31.581943f
            , 31.583170f
            , 31.577536f
            , 31.578801f
            , 31.579351f
            , 31.580785f
            , 31.581679f
            , 31.579003f
            , 31.579067f
            , 31.580693f
            , 31.580626f
            , 31.578390f
            , 31.579386f
            , 31.579132f
            , 31.577293f
            , 31.579445f
    };

    Float[] placeLong = {
            74.355140f
            , 74.351553f
            , 74.357853f
            , 74.351528f
            , 74.353027f
            , 74.360034f
            , 74.354165f
            , 74.356085f
            , 74.356146f
            , 74.355131f
            , 74.357017f
            , 74.357467f
            , 74.354411f
            , 74.355907f
            , 74.357421f
            , 74.355485f
            , 74.354299f
            , 74.352553f // gates 0
            , 74.354413f // gates 1
            , 74.355636f // gates 2
            , 74.356720f // gates 3
            , 74.358374f // gates 4
            , 74.359905f // gates 5
            , 74.360573f // gates 6
            , 74.356753f
            , 74.358013f
            , 74.354597f
            , 74.355983f
            , 74.353048f
            , 74.353017f
            , 74.357380f
            , 74.352054f
            , 74.353668f
            , 74.356939f
            , 74.351632f // iqbal hall canteen
            , 74.351871f
            , 74.355264f
            , 74.359995f
            , 74.351845f
            , 74.355145f
            , 74.355901f
            , 74.358994f
            , 74.359962f
            , 74.357821f
            , 74.355704f
            , 74.358392f
            , 74.358490f
            , 74.356817f
            , 74.352171f
            , 74.351578f // mumtaz hall canteen
            , 74.352056f
            , 74.355919f
            , 74.353148f
            , 74.351723f
            , 74.357082f
            , 74.353216f
            , 74.362204f
            , 74.354625f
            , 74.362141f
            , 74.356762f
            , 74.359987f
            , 74.357798f
            , 74.355142f
            , 74.351187f
            , 74.356883f
            , 74.352679f // sharqi gate
            , 74.353248f
            , 74.351166f
            , 74.358256f
            , 74.353468f
            , 74.354059f
            , 74.353605f
            , 74.352665f
            , 74.354202f
            , 74.353167f
            , 74.352939f
            , 74.354106f
            , 74.353803f
            , 74.357509f
            , 74.354149f
            , 74.355105f
            , 74.354300f
            , 74.354555f
            , 74.362152f
            , 74.359338f
            , 74.352505f
            , 74.352301f
    };

    private GoogleMap mMap;
    private GoogleMap map;
    private SupportMapFragment fragment;
    private LatLngBounds latlngBounds;
    private Polyline newPolyline;
    private int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation);


        // receiving location from navigation
        if (savedInstanceState == null) {

            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                placeToShow = null;
            } else {
                placeToShow = extras.getString("placeToShow");
            }
        } else {
            placeToShow = (String) savedInstanceState.getSerializable("placeToShow");
        }


        getScreenDimanstions();
        fragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
        map = fragment.getMap();
        fragment.getMapAsync(this);


        bNavigation = (Button) findViewById(R.id.bNavigation);
        View.OnClickListener findClickListenerNav = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationButtonFunc();

                hideKeyboard();

            }
        };
        bNavigation.setOnClickListener(findClickListenerNav);


        mBtnFind = (Button) findViewById(R.id.searchButton);
        View.OnClickListener findClickListenerSearch = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchButtonFunc();

                hideKeyboard();

            }
        };
        mBtnFind.setOnClickListener(findClickListenerSearch);
        ////////////////////////////////////////////////////////////


        map.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {

                LatLng myCurrentLocation = uet;

                // Getting Current Values of CameraPosition
                float currentZoom = cameraPosition.zoom;
                float currentTilt = cameraPosition.tilt;
                float currentBearing = cameraPosition.bearing;

                if (!isCameraInBound()) {
                    CameraPosition cam = new CameraPosition.Builder()
                            .target(myCurrentLocation)      // Sets the center of the map to Mountain View
                            .zoom(currentZoom)                    // Sets the zoom
                            .bearing(currentBearing)                           // Sets the orientation of the camera to east
                            .tilt(currentTilt)                   // Sets the tilt of the camera to 30 degrees
                            .build();                   // Creates a CameraPosition from the builder
                    map.animateCamera(CameraUpdateFactory.newCameraPosition(cam));
                }
            }
        });

    }

    @Override
    protected void onResume() {

        super.onResume();
        latlngBounds = createLatLngBoundsObject(CornerOne, CornerTwo);
        map.moveCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds, width, height, 150));

    }

    ////////////////////////////////////////////////////////////
    /// Navigation Functions
    public void handleGetDirectionsResult(ArrayList<LatLng> directionPoints) {
        PolylineOptions rectLine = new PolylineOptions().width(5).color(Color.RED);
        for (int i = 0; i < directionPoints.size(); i++) {
            rectLine.add(directionPoints.get(i));
        }
        if (newPolyline != null) {
            newPolyline.remove();
        }
        newPolyline = map.addPolyline(rectLine);

        // Construct a CameraPosition focusing on UET and animate the camera to that position.
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(navOrig)      // Sets the center of the map to Mountain View
                .zoom(16)                   // Sets the zoom
                .bearing(0)                // Sets the orientation of the camera to east
                .tilt(0)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder

        latlngBounds = createLatLngBoundsObject(CornerOne, CornerTwo);
        //map.animateCamera(CameraUpdateFactory.newLatLngBounds(latlngBounds, width, height, 150));
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    private void getScreenDimanstions() {
        Display display = getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();
    }
    ////////////////////////////////////////////////////////////

    private LatLngBounds createLatLngBoundsObject(LatLng firstLocation, LatLng secondLocation) {
        if (firstLocation != null && secondLocation != null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(firstLocation).include(secondLocation);

            return builder.build();
        }
        return null;
    }

    public void findDirections(double fromPositionDoubleLat, double fromPositionDoubleLong,
                               double toPositionDoubleLat, double toPositionDoubleLong, String mode) {
        Map<String, String> map = new HashMap<String, String>();
        map.put(GetDirectionsAsyncTask.USER_CURRENT_LAT, String.valueOf(fromPositionDoubleLat));
        map.put(GetDirectionsAsyncTask.USER_CURRENT_LONG, String.valueOf(fromPositionDoubleLong));
        map.put(GetDirectionsAsyncTask.DESTINATION_LAT, String.valueOf(toPositionDoubleLat));
        map.put(GetDirectionsAsyncTask.DESTINATION_LONG, String.valueOf(toPositionDoubleLong));
        map.put(GetDirectionsAsyncTask.DIRECTIONS_MODE, mode);

        GetDirectionsAsyncTask asyncTask = new GetDirectionsAsyncTask(this);
        asyncTask.execute(map);
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onMapLongClick(LatLng latLng) {

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onMapReady(GoogleMap map) {

        checkGPS();

        if (placeToShow != null)
            searchingForFavouritePlace();


        mMap = map;

        // We will provide our own controls
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.getUiSettings().setZoomGesturesEnabled(false);
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.setMyLocationEnabled(true);




        // Construct a CameraPosition focusing on UET and animate the camera to that position.
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(uet)      // Sets the center of the map to Mountain View
                .zoom(15)                   // Sets the zoom
                .bearing(0)                // Sets the orientation of the camera to east
                .tilt(0)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder

            map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


        // setup zoom control buttons
        Button zoomout = (Button) findViewById(R.id.bzoomout);
        zoomout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                zoomOutButtonFunc();
            }

        });
        Button zoomin = (Button) findViewById(R.id.bzoomin);
        zoomin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                zoomInButtonFunc();
            }
        });
    }

    void checkGPS() {
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();
        }

    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog,
                                        @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();

                        Intent main_intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(main_intent);
                        MainActivity.mainActivityObject.finish();
                        finish();


                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private boolean haveNetworkConnection() {

        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;


    }

    void searchButtonFunc() {
        // Getting reference to EditText to get the user input location
        etPlace = (AutoCompleteTextView) findViewById(R.id.searchedPlace);

        // Getting user input location

        String location = etPlace.getText().toString();

        // if search term is in box then keep location with what in box even if you come from places activity before
        // and delete the history you got from places activity
        if (location != null && !location.equals(""))
            placeToShow = null;
            // if search term is not in box then if previous activity is places (favourites) then there is a place to put in location
        else if (placeToShow != null)
            location = placeToShow;

        // Check if there is place entered
        if (location != null && !location.equals("")) {

            int isPlaceExist = findPlaceInArray(location);

            // tag found
            if (isPlaceExist == -2) {
                location = location.toLowerCase();
                if (location.charAt(location.length() - 1) == ' ') {
                    location = location.substring(0, location.length() - 1);
                }
                map.clear();

                for (int i = 0; i < numberOfPlaces; ++i) {
                    if (tags[i].equals(location)) {
                        LatLng searchedPlace = new LatLng(placeLat[i], placeLong[i]);
                        markerOptions = new MarkerOptions();
                        markerOptions.position(searchedPlace);
                        markerOptions.title(placeName[i]);
                        map.addMarker(markerOptions);
                        map.animateCamera(CameraUpdateFactory.newLatLng(searchedPlace));
                    }
                }
                // place found
            } else if (isPlaceExist != -1) {
                map.clear();
                LatLng searchedPlace = new LatLng(placeLat[isPlaceExist], placeLong[isPlaceExist]);
                markerOptions = new MarkerOptions();
                markerOptions.position(searchedPlace);
                markerOptions.title(toTitleCase(placeName[isPlaceExist]));
                map.addMarker(markerOptions);
                map.animateCamera(CameraUpdateFactory.newLatLng(searchedPlace));
            } else {
                Toast.makeText(getBaseContext(), "Place is not recognized", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getBaseContext(), "Enter place first", Toast.LENGTH_SHORT).show();
        }
    }

    void searchingForFavouritePlace() {
        String location = placeToShow;

        int isPlaceExist = findPlaceInArray(location);

        map.clear();
        LatLng searchedPlace = new LatLng(placeLat[isPlaceExist], placeLong[isPlaceExist]);
        markerOptions = new MarkerOptions();
        markerOptions.position(searchedPlace);
        markerOptions.title(toTitleCase(placeName[isPlaceExist]));
        map.addMarker(markerOptions);
        map.animateCamera(CameraUpdateFactory.newLatLng(searchedPlace));
    }

    void navigationButtonFunc() {

        // Getting reference to EditText to get the user input location
        etPlace = (AutoCompleteTextView) findViewById(R.id.searchedPlace);

        // Getting user input location
        String location = etPlace.getText().toString();

        // if search term is in box then keep location with what in box even if you come from places activity before
        if (location != null && !location.equals(""))
            ;
            // if search term is not in box then if previous activity is places (favourites) then there is a place to put in location
        else if (placeToShow != null)
            location = placeToShow;

        if (location != null && !location.equals("")) {

            // Check if internet is turned on
            if (haveNetworkConnection()) {

                // Getting the index of the place if found in names, or -2 if in tags, or -1 if not found
                int isPlaceExist = findPlaceInArray(location);

                // tag found
                if (isPlaceExist == -2) {
                    Toast.makeText(getBaseContext(), "Navigation is not supported for tag search", Toast.LENGTH_SHORT).show();
                    map.animateCamera(CameraUpdateFactory.newLatLng(uet));
                }
                // place name found
                else if (isPlaceExist != -1) {
                    // clear
                    map.clear();

                    // destination
                    navDest = new LatLng(placeLat[isPlaceExist], placeLong[isPlaceExist]);
                    markerOptions = new MarkerOptions();
                    markerOptions.position(navDest);
                    markerOptions.title(toTitleCase(placeName[isPlaceExist]));
                    map.addMarker(markerOptions);

                    // source
                    myLocation = map.getMyLocation();
                    if (myLocation != null) {
                        double dLatitude = myLocation.getLatitude();
                        double dLongitude = myLocation.getLongitude();
                        LatLng myCurrentLocation = new LatLng(dLatitude, dLongitude);
                        markerOptions = new MarkerOptions();
                        markerOptions.position(myCurrentLocation);
                        markerOptions.title("You are Here");
                        map.addMarker(markerOptions);

                        navOrig = new LatLng(dLatitude, dLongitude);


                        findDirections(myCurrentLocation.latitude, myCurrentLocation.longitude,
                                navDest.latitude, navDest.longitude, GMapV2Direction.MODE_WALKING);

                    }
                    // Can't retrieve the position and location contains null
                    else {
                        Toast.makeText(getBaseContext(), "Can't retrieve you position right now", Toast.LENGTH_SHORT).show();
                        map.animateCamera(CameraUpdateFactory.newLatLng(uet));
                    }
                }
                // place name not found
                else
                    Toast.makeText(getBaseContext(), "Place is not recognized", Toast.LENGTH_SHORT).show();
            }
            // Internet is turned off
            else
                Toast.makeText(getBaseContext(), "Navigation Needs Internet Connection", Toast.LENGTH_SHORT).show();
        }
        // No place entered
        else
            Toast.makeText(getBaseContext(), "Enter place first", Toast.LENGTH_SHORT).show();

    }

    void zoomOutButtonFunc() {
        if (mMap.getCameraPosition().zoom >= 15.0f) {
            // Zoom like normal
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        } else {
            Toast.makeText(getBaseContext(), "Maximum zoom out level reached", Toast.LENGTH_SHORT).show();
        }
    }

    void zoomInButtonFunc() {
        if (mMap.getCameraPosition().zoom <= 23.0f) {
            // Zoom like normal
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        } else {
            Toast.makeText(getBaseContext(), "Maximum zoom in level reached", Toast.LENGTH_SHORT).show();

        }
    }

    int findPlaceInArray(String place) {

        place = place.toLowerCase();


        if (place.charAt(place.length() - 1) == ' ') {
            place = place.substring(0, place.length() - 1);
        }

        for (int i = 0; i < numberOfPlaces; ++i) {
            if (place.equals(placeName[i]))
                return i;
            else if (place.equals(placeCommonName[i]))
                return i;
            else if (place.equals(tags[i]))
                return -2;
        }
        return -1;

    }

    boolean isCameraInBound() {

        LatLng pos = map.getCameraPosition().target;

        //LatLng cor1 = new LatLng(31.583581, 74.348670);
        LatLng cor1 = new LatLng(31.583581, 74.348670);
        LatLng cor2 = new LatLng(31.577920, 74.362993);

        if (pos.latitude > cor1.latitude)
            return false;
        else if (pos.latitude < cor2.latitude)
            return false;
        else if (pos.longitude < cor1.longitude)
            return false;
        else if (pos.longitude > cor2.longitude)
            return false;
        else return true;
    }

    void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    public static String toTitleCase(String givenString) {
        String[] arr = givenString.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

}