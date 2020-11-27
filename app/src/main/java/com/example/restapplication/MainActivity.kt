package com.example.restapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    var title_List:ArrayList<String> = ArrayList<String>();
    var url:String="https://jsonplaceholder.typicode.com/posts";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData();
        var re_view:RecyclerView=this.findViewById(R.id.re_view);
        var lm:RecyclerView.LayoutManager=LinearLayoutManager(this);
        re_view.layoutManager=lm;
        re_view.setHasFixedSize(true);

        var adapter:MyAdapter= MyAdapter(title_List);
        re_view.adapter=adapter;



    }

    fun loadData(){

        var stringRequest:StringRequest= StringRequest(Request.Method.GET,url, Response.Listener<String> { response->
            var jsonarray:JSONArray=JSONArray(response);
            for(items in 0 until jsonarray.length()){
                var jsonobj:JSONObject=jsonarray.getJSONObject(items);
                title_List.add(jsonobj.getString("body"));

            }
            Toast.makeText(this@MainActivity,"Data Loading Done!! "+title_List.size,Toast.LENGTH_SHORT).show();

            var re_view:RecyclerView=this.findViewById(R.id.re_view);
            var lm:RecyclerView.LayoutManager=LinearLayoutManager(this);
            re_view.layoutManager=lm;
            re_view.setHasFixedSize(true);

            var adapter:MyAdapter= MyAdapter(title_List);
            re_view.adapter=adapter;

        },Response.ErrorListener { Toast.makeText(this@MainActivity,"Error Loading Data!!",Toast.LENGTH_SHORT).show(); });

        var requestQueue:RequestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);



    }

}


