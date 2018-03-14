package com.bovink.androidlearning.databinding.generatebinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;

import com.bovink.androidlearning.databinding.GenerateViewActBinding;
import com.bovink.androidlearning.databinding.ViewstubShowBinding;
import com.bovink.androidlearning.model.Person;

/**
 * @author fox
 * @since 2018/03/14
 */

public class GenerateViewActivity extends AppCompatActivity {

    GenerateViewActBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = GenerateViewActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Person person = new Person();
        person.setName("liu");
        person.setSex("male");
        binding.setPerson(person);
        person = binding.getPerson();

        binding.changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.introduceTextView.setText("you have change text");
            }
        });

        final Person finalPerson = person;
        binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                ViewstubShowBinding viewstubShowBinding = DataBindingUtil.bind(inflated);
                viewstubShowBinding.setPerson(finalPerson);

            }
        });

        EventHandler handler = new EventHandler();
        binding.setHandler(handler);
    }

    public class EventHandler {

        public void inflateView() {
            if (!binding.viewStub.isInflated()) {

                binding.viewStub.getViewStub().inflate();
            }

        }
    }
}
