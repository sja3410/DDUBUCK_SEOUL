package com.example.myapplication.GuroGeumcheon;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GuroGeumcheonCourse1 extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;
    MarkerOptions place1, place2, place3; // 장소 객체 생성

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guro_geumcheon_course1);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFrag);
        mapFragment.getMapAsync(this);

        place1 = new MarkerOptions().position(new LatLng(37.4990149 ,126.867227)).title("고척스카이돔").snippet("야구장");
        place2 = new MarkerOptions().position(new LatLng(37.5059163, 126.851992)).title("고척근린공원").snippet("근린공원");
        place3 = new MarkerOptions().position(new LatLng(37.4888198,126.835088)).title("항동철길").snippet("관광지");

        final ToggleButton tb2 = (ToggleButton) this.findViewById(R.id.toggleButton2);

        tb2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(tb2.isChecked()){
                    tb2.setBackgroundDrawable(
                            getResources().
                                    getDrawable(R.drawable.full_heart_button)
                    );
                }else{
                    tb2.setBackgroundDrawable(
                            getResources().
                                    getDrawable(R.drawable.empty_heart_button)
                    );
                } // end if
            } // end onClick()
        });

        myDialog = new Dialog(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        map.addMarker(place1); // 장소를 알았으니, 마커를 찍기
        map.addMarker(place2);
        map.addMarker(place3);

        LatLng zoom = new LatLng(37.496429, 126.851085); // 줌인 할 수 있는 장소 만들기
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(zoom, 13)); // v값은 배율을 의미 (값이 작을수록 zoom out / 값이 클수록 zoom in)
        //googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(zoom,11)); // moveCamera 는 정적인 지도 움직임, animateCamera 는 동적인 지도 움직임
    }

    public void ShowPopup(View view) {
        TextView X_button;
        myDialog.setContentView(R.layout.activity_gurogeumcheoncourse1_popup_window);
        X_button = (TextView)myDialog.findViewById(R.id.x_button);
        X_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }


}