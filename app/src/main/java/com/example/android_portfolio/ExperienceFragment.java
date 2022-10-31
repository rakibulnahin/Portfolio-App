package com.example.android_portfolio;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExperienceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExperienceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExperienceFragment() {
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
    public static ExperienceFragment newInstance(String param1, String param2) {
        ExperienceFragment fragment = new ExperienceFragment();
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

    String projects [] = {
            "web-Online Food Management System (MERN, React JS)",
            "web-Ecommerce Car Rental System (MERN, React JS)",
            "web-Art Gallery (MERN, React JS)",
            "app-Color coded Task List (React Native)",
            "app-Covid Oracle (Android Java)",
            "app-Home Tracker (Android Java)",
            "app-Portfolio App (Android Java)",
            "other-Plastic Detection(Python, Tensorflow)",
            "other-Plastic Detection (Python, OpenCV) ",
            "other-Color Ball Detection (Python, OpenCV) ",
            "other-Sketch Board (Python, OpenCV) ",
            "other-Human Detection (Python, OpenCV) ",
            "other-Image Detection (Python, Tensorflow) ",
            "other-Ping Pong GUI (Python GUI)",
            "other-Windows Voice Assistant (Python)",
            "other-Human Activity Detection (Python, Data Analysis)"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_experience, container, false);
        CustomListView customListView = new CustomListView(view.getContext(), projects);
        ListView listView = view.findViewById(R.id.project_list_view);
        listView.setAdapter(customListView);

        return view;
    }
}

class CustomListView extends BaseAdapter{

    String projects [];
    Context context;
    LayoutInflater layoutInflater;

    CustomListView(Context context, String [] projects){
        this.context = context;
        this.projects = projects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return projects.length;
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

        view = layoutInflater.inflate(R.layout.listview_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.listview_img);
        TextView textView = (TextView) view.findViewById(R.id.listview_text);
        LinearLayout li = (LinearLayout) view.findViewById(R.id.listview_li_layout);
        String [] s = projects[i].split("-");
        if (s[0].equals("web")){
            imageView.setImageResource(R.drawable.web);
//            textView.setBackgroundResource(R.color.yellow);
//            li.setBackgroundColor(view.getResources().getColor(R.color.yellow));
//            textView.setTextColor(view.getResources().getColor(R.color.black));
        }else if (s[0].equals("app")){
            imageView.setImageResource(R.drawable.app);
//            textView.setBackgroundResource(R.color.ash);
//            li.setBackgroundColor(view.getResources().getColor(R.color.ash));
//            textView.setTextColor(view.getResources().getColor(R.color.white));
        }else{
            imageView.setImageResource(R.drawable.program);
        }

        textView.setText(s[1]);

        return view;
    }
}