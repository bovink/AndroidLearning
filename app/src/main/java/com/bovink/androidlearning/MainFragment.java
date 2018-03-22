package com.bovink.androidlearning;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bovink.androidlearning.databinding.FragmentMainBinding;
import com.bovink.androidlearning.databinding.ItemStudentBinding;
import com.bovink.androidlearning.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fox
 * @since 2018/03/21
 */

public class MainFragment extends Fragment {

    private Context mContext;
    private List<Student> students = new ArrayList<>();

    public static MainFragment newInstance() {

        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getContext();
        students.add(new Student("lilei", "12"));
        students.add(new Student("hanmeimei", "12"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentMainBinding binding = FragmentMainBinding.inflate(inflater);
        binding.studentRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        binding.studentRecyclerView.setAdapter(new StudentAdapter());
        return binding.getRoot();

    }

    public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

        @Override
        public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ItemStudentBinding binding = ItemStudentBinding.inflate(LayoutInflater.from(mContext),parent,false);
            return new StudentViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(StudentViewHolder holder, int position) {

            MainViewModel viewModel = new MainViewModel();
            viewModel.setStudentObservable(students.get(position));
            holder.bind(viewModel);
        }

        @Override
        public int getItemCount() {
            return students.size();
        }

        public class StudentViewHolder extends RecyclerView.ViewHolder {

            private ItemStudentBinding binding;

            public StudentViewHolder(ItemStudentBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }

            public void bind(MainViewModel viewModel) {
                binding.setViewModel(viewModel);
                binding.executePendingBindings();
            }
        }
    }


}
