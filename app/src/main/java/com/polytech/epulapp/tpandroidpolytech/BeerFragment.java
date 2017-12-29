package com.polytech.epulapp.tpandroidpolytech;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.polytech.epulapp.tpandroidpolytech.models.Beer;
import com.polytech.epulapp.tpandroidpolytech.services.APICallback;
import com.polytech.epulapp.tpandroidpolytech.services.BeerAccessService;
import com.polytech.epulapp.tpandroidpolytech.utils.ClickListener;
import com.polytech.epulapp.tpandroidpolytech.utils.IBeerClick;
import com.polytech.epulapp.tpandroidpolytech.utils.RecyclerTouchListener;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class BeerFragment extends Fragment  {

    private IBeerClick clickListener;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BeerFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static BeerFragment newInstance(int columnCount) {
        BeerFragment fragment = new BeerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beer_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
             final RecyclerView recyclerView = (RecyclerView) view;

            if (mColumnCount <= 1) {

                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            BeerAccessService.getInstance().GetApiData(context, view, new APICallback() {
                @Override
                public void onSuccess(@NonNull List<Beer> value) {
                    final List<Beer> lstBeers = value;
                    recyclerView.setAdapter(new BeerRecyclerViewAdapter(lstBeers, R.layout.fragment_beer_list, context));



                    recyclerView.addOnItemTouchListener(
                            new RecyclerTouchListener(context, recyclerView ,new ClickListener()  {
                                @Override public void onClick(View view, int index) {
                                    clickListener = (IBeerClick) getActivity();
                                    clickListener.onItemClick(view,index,lstBeers);
                                }


                            }    )
                    );



                }

                @Override
                public void onError(@NonNull Throwable throwable) {

                }
            });


        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Beer beer);
    }


}
