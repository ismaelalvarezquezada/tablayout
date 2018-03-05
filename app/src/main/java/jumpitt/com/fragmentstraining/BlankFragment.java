package jumpitt.com.fragmentstraining;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    @BindView(R.id.btn_action)
    Button btnAction;
    @BindView(R.id.et_action)
    EditText etAction;
    Unbinder unbinder;
    FragmentListener listener;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_blank, container, false);


        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_action)
    public void onViewClicked() {
        sendText(etAction.getText().toString());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (FragmentListener) context;
        }catch (Exception e){
            throw new ClassCastException(context.toString() + "should implement listener");
        }
    }

    private void sendText(String text){
        listener.sendData(text);
    }

    public interface  FragmentListener{
        void sendData(String message);
    }
}
