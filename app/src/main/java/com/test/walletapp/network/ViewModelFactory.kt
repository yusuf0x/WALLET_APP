package com.test.walletapp.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.walletapp.network.viewmodels.LoginViewModel


class ViewModelFactory(
    private val apiHelper: ApiHelper,
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(apiHelper) as T
        }
//        if (modelClass.isAssignableFrom(SeriesNetworkCallsViewModel::class.java)) {
//            return SeriesNetworkCallsViewModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
//        if (modelClass.isAssignableFrom(ParallelNetworkCallsViewModel::class.java)) {
//            return ParallelNetworkCallsViewModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
//        if (modelClass.isAssignableFrom(RoomDBViewModel::class.java)) {
//            return RoomDBViewModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
//        if (modelClass.isAssignableFrom(CatchViewModel::class.java)) {
//            return CatchViewModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
//        if (modelClass.isAssignableFrom(EmitAllViewModel::class.java)) {
//            return EmitAllViewModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
//        if (modelClass.isAssignableFrom(LongRunningTaskViewModel::class.java)) {
//            return LongRunningTaskViewModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
//        if (modelClass.isAssignableFrom(TwoLongRunningTasksViewModel::class.java)) {
//            return TwoLongRunningTasksViewModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
//        if (modelClass.isAssignableFrom(CompletionViewModel::class.java)) {
//            return CompletionViewModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
//        if (modelClass.isAssignableFrom(FilterViewModel::class.java)) {
//            return FilterViewModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
//        if (modelClass.isAssignableFrom(MapViewModel::class.java)) {
//            return MapViewModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
//        if (modelClass.isAssignableFrom(ReduceViewModel::class.java)) {
//            return ReduceViewModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
//        if (modelClass.isAssignableFrom(RetryViewModel::class.java)) {
//            return RetryViewModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
//        if (modelClass.isAssignableFrom(RetryWhenViewModel::class.java)) {
//            return RetryWhenViewModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
//        if (modelClass.isAssignableFrom(RetryExponentialBackoffModel::class.java)) {
//            return RetryExponentialBackoffModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
//        if (modelClass.isAssignableFrom(FlowOnViewModel::class.java)) {
//            return FlowOnViewModel(apiHelper, dbHelper, dispatcherProvider) as T
//        }
        throw IllegalArgumentException("Unknown class name")
    }

}