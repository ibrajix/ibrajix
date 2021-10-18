/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.ibrajix.ui.fragments

import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ibrajix.ibrajix.R
import com.ibrajix.ibrajix.databinding.FragmentContactBinding
import com.ibrajix.ibrajix.utils.viewBinding

class ContactFragment : Fragment() {

    private val binding by viewBinding(FragmentContactBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews(){
        handleClicks()
    }

    private fun handleClicks(){

        //on click lyt email
        binding.lytEmail.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW)
            val data = Uri.parse("mailto:ibrajix@gmail.com?subject=Hello!")
            intent.data = data
            startActivity(intent)

        }

        //on click lyt twitter
        binding.lytTwitter.setOnClickListener {

            val intent: Intent = try {
                // Check if the Twitter app is installed on the phone.
                context?.packageManager?.getPackageInfo("com.twitter.android", 0)
                Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=997129876275593216"))
            } catch (e: Exception) {
                Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ibrajix"))
            }
            context?.startActivity(intent)

        }

        //on click lyt instagram
        binding.lytInstagram.setOnClickListener {

            val uriForApp: Uri = Uri.parse("http://instagram.com/_u/ibrajix")
            val forApp = Intent(Intent.ACTION_VIEW, uriForApp)

            val uriForBrowser: Uri = Uri.parse("http://instagram.com/ibrajix")
            val forBrowser = Intent(Intent.ACTION_VIEW, uriForBrowser)

            forApp.component =
                ComponentName(
                    "com.instagram.android",
                    "com.instagram.android.activity.UrlHandlerActivity"
                )

            try {
                startActivity(forApp)
            } catch (e: ActivityNotFoundException) {
                startActivity(forBrowser)
            }

        }

        //on click lyt youtube
        binding.lytYoutube.setOnClickListener {

            val url = "https://www.youtube.com/channel/UCX1-R2MjG3LqmDVmm9JJI6Q"

            var intent: Intent?
            try {
                intent = Intent(Intent.ACTION_VIEW)
                intent.setPackage("com.google.android.youtube")
                intent.data = Uri.parse(url)
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            }
        }

        //on click lyt github
        binding.lytGithub.setOnClickListener {

            val url = "https://github.com/ibrajix"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }

        //on click lyt medium
        binding.lytMedium.setOnClickListener {
            val url = "https://ibrajix.medium.com/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }


    }

}