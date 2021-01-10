package com.example.finn.vm

import androidx.lifecycle.ViewModel
import com.example.finn.AdRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdViewModel @Inject constructor(repo: AdRepo) : ViewModel()