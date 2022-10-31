package com.example.android_portfolio;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CertificationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CertificationsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CertificationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CertificationsFragment newInstance(String param1, String param2) {
        CertificationsFragment fragment = new CertificationsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    String [] course = {
            "Introduction to Tensorflow for Artifical Intelligence, Machine Learning and Deep Learning",
            "Recurrent Neural Networks (RNN) for Language Modeling in Python",
            "Data Visualization",
            "Pandas",
            "Introduction to Cybersecurity Tools and Cyber Attacks",
            "Machine Learning with scikit-learn",
            "Unsupervised Learning in Python",

    };

    int [] course_img = {
            R.drawable.c1,
            R.drawable.c2,
            R.drawable.c3,
            R.drawable.c4,
            R.drawable.c5,
            R.drawable.c6,
            R.drawable.c7,

    };

    String [] comps = {
            "NASA International Space Apps Challenge 2021",
            "International Planetary Aerial System Challenge"
    };

    int [] comp_img = {
            R.drawable.comp1,
            R.drawable.comp2,
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_certifications, container, false);

        ListView course_listview = (ListView) view.findViewById(R.id.course_listview);
        CustomAdapter customAdapter = new CustomAdapter(view.getContext(), this.course, course_img);
        course_listview.setAdapter(customAdapter);

        ListView competition_listview = view.findViewById(R.id.competition_listview);
        customAdapter = new CustomAdapter(view.getContext(), this.comps, this.comp_img);
        competition_listview.setAdapter(customAdapter);

        return view;
    }
}

class CustomAdapter extends BaseAdapter{

    Context context;
    String [] course;
    int [] img;
    LayoutInflater layoutInflater;

    CustomAdapter(Context context, String [] s, int [] img){
        this.context = context;
        this.course = s;
        this.img = img;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return course.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = layoutInflater.inflate(R.layout.listview_layout2, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.listview2_img);
        TextView textView = (TextView) view.findViewById(R.id.listview2_text);

        imageView.setImageResource(this.img[i]);
        textView.setText(this.course[i]);

        return view;
    }
}