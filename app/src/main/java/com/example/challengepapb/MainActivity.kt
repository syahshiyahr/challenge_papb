package com.example.challengepapb

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.challengepapb.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val REQUEST_CODE_HEAD = 100
    val REQUEST_CODE_HAIR = 101
    val REQUEST_CODE_MOUSTACHE = 102
    val REQUEST_CODE_EYES = 103
    val REQUEST_CODE_EYEBROW = 104
    val REQUEST_CODE_BEARD = 105

    var headImageUri:Uri = Uri.parse("")
    var hairImageUri:Uri = Uri.parse("")
    var moustacheImageUri:Uri = Uri.parse("")
    var eyesImageUri:Uri = Uri.parse("")
    var eyebrowImageUri:Uri = Uri.parse("")
    var beardImageUri:Uri = Uri.parse("")


    companion object {
        private const val STATE_RESULT_HEAD = "state_result_head"
        private const val STATE_RESULT_HAIR = "state_result_hair"
        private const val STATE_RESULT_MOUSTACHE = "state_result_moustache"
        private const val STATE_RESULT_EYES = "state_result_eyes"
        private const val STATE_RESULT_EYEBROW = "state_result_eyebrow"
        private const val STATE_RESULT_BEARD = "state_result_beard"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState!=null) {
            binding.body.setImageURI(savedInstanceState.getParcelable(STATE_RESULT_HEAD))
            binding.hair.setImageURI(savedInstanceState.getParcelable(STATE_RESULT_HAIR))
            binding.moustache.setImageURI(savedInstanceState.getParcelable(STATE_RESULT_MOUSTACHE))
            binding.eyes.setImageURI(savedInstanceState.getParcelable(STATE_RESULT_EYES))
            binding.eyebrow.setImageURI(savedInstanceState.getParcelable(STATE_RESULT_EYEBROW))
            binding.beard.setImageURI(savedInstanceState.getParcelable(STATE_RESULT_BEARD))

            headImageUri = savedInstanceState.getParcelable(STATE_RESULT_HEAD)!!
            hairImageUri = savedInstanceState.getParcelable(STATE_RESULT_HAIR)!!
            moustacheImageUri = savedInstanceState.getParcelable(STATE_RESULT_MOUSTACHE)!!
            eyesImageUri = savedInstanceState.getParcelable(STATE_RESULT_EYES)!!
            eyebrowImageUri = savedInstanceState.getParcelable(STATE_RESULT_EYEBROW)!!
            beardImageUri = savedInstanceState.getParcelable(STATE_RESULT_BEARD)!!

        }

        binding.btnBrowseHead.setOnClickListener {
            openGallery(REQUEST_CODE_HEAD)
        }

        binding.btnBrowseHair.setOnClickListener {
            openGallery(REQUEST_CODE_HAIR)
        }

        binding.btnBrowseMoustache.setOnClickListener {
            openGallery(REQUEST_CODE_MOUSTACHE)
        }

        binding.btnBrowseEyes.setOnClickListener {
            openGallery(REQUEST_CODE_EYES)
        }

        binding.btnBrowseEyebrow.setOnClickListener {
            openGallery(REQUEST_CODE_EYEBROW)
        }

        binding.btnBrowseBeard.setOnClickListener {
            openGallery(REQUEST_CODE_BEARD)
        }


    }

    private fun openGallery(requestCode: Int) {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        intent.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(intent, requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_HEAD){
            binding.body.setImageURI(data?.data) // handle chosen image
            headImageUri = data?.data!!
        }else if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_HAIR){
            binding.hair.setImageURI(data?.data)
            hairImageUri = data?.data!!
        }else if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_MOUSTACHE){
            binding.moustache.setImageURI(data?.data)
            moustacheImageUri = data?.data!!
        }else if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_EYES){
            binding.eyes.setImageURI(data?.data)
            eyesImageUri = data?.data!!
        }else if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_EYEBROW){
            binding.eyebrow.setImageURI(data?.data)
            eyebrowImageUri = data?.data!!
        }else if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_BEARD){
            binding.beard.setImageURI(data?.data)
            beardImageUri = data?.data!!
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(STATE_RESULT_HAIR, hairImageUri)
        outState.putParcelable(STATE_RESULT_HEAD, headImageUri)
        outState.putParcelable(STATE_RESULT_MOUSTACHE, moustacheImageUri)
        outState.putParcelable(STATE_RESULT_EYES, eyesImageUri)
        outState.putParcelable(STATE_RESULT_EYEBROW, eyebrowImageUri)
        outState.putParcelable(STATE_RESULT_BEARD, beardImageUri)

    }


}