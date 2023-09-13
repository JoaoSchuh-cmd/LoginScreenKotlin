package com.pucpr.pos.loginscreenkotlin.repository

import android.net.Uri
import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class StorageRepository {
    companion object {
        val storage = Firebase.storage
        val storageReference = storage.reference

        fun addImage(
            imagePath : String = "images",
            imageName : String,
            uri : Uri
        ) {
            val imageRef = storageReference.child("$imagePath/$imageName")

            imageRef.putFile(uri)
                .addOnSuccessListener { taskSnapshot ->
                    val downloadUrl = taskSnapshot.metadata?.reference?.downloadUrl
                    if (downloadUrl != null) {

                    }
                }
                .addOnFailureListener { e ->
                    Log.d("AddImage Error", e.message.toString())
                }
        }
    }

}