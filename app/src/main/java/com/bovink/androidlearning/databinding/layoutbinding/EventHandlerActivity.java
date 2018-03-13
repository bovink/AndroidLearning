package com.bovink.androidlearning.databinding.layoutbinding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bovink.androidlearning.databinding.EventHandlerActBinding;
import com.bovink.androidlearning.model.Person;

/**
 * @author fox
 * @since 2018/03/13
 */

public class EventHandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventHandlerActBinding binding = EventHandlerActBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Person person1 = new Person();
        person1.setName("lilei");

        Person person2 = new Person();
        person2.setName("hanmeimei");

        binding.setPerson1(person1);
        binding.setPerson2(person2);

        MethodReference methodReference = new MethodReference();
        ListenerBinding listenerBinding = new ListenerBinding();

        binding.setReference(methodReference);
        binding.setBinding(listenerBinding);
    }

    /**
     * 必须与要绑定的接口的回调方法的签名一致
     */
    public class MethodReference {

        public void methodDoSomething(View view) {

            System.out.println("MethodReference.methodDoSomething");
        }
    }

    /**
     * 只需要与要绑定接口的回调方法的返回值一致
     */
    public class ListenerBinding {

        public void listenerDoSomething() {

            System.out.println("ListenerBinding.listenerDoSomething");
        }
    }
}
