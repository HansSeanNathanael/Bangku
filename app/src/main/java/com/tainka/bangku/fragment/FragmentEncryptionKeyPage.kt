package com.tainka.bangku.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.tainka.bangku.databinding.FragmentEncryptionKeyPageBinding
import com.tainka.bangku.utilities.KeyPadder

private const val ARG_PARAM1 = "mainMenuFragment"

class FragmentEncryptionKeyPage : Fragment() {
    private lateinit var binding : FragmentEncryptionKeyPageBinding
    private lateinit var mainMenuFragment : FragmentFileListPage

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEncryptionKeyPageBinding.inflate(inflater, container, false)

        mainMenuFragment = arguments?.getSerializable(ARG_PARAM1) as FragmentFileListPage

        binding.buttonSubmitKey.setOnClickListener {
            val keyLength = binding.keyTextField.text.toString().length
            if (keyLength in 8..16)
            {
                //check for password compatibility (char must 'a'-'z', '
                var compatible = true
                binding.keyTextField.text.toString().forEach {
                    if ( !((it.code >= 'A'.code && it.code <= 'Z'.code) || (it.code >= 'a'.code && it.code <= 'z'.code) ||
                          (it.code >= '0'.code && it.code <= '9'.code)))
                    {
                        compatible = false
                    }
                }
                if (compatible)
                {
                    val encryptionKey = KeyPadder.padKey(binding.keyTextField.text.toString())
                    mainMenuFragment.setNewKey(encryptionKey)
                    this.findNavController().navigateUp()
                }
                else
                {
                    binding.errorMessage.visibility = View.VISIBLE
                    binding.errorMessage.text = getString(com.tainka.bangku.R.string.wrongKeyCharacter)
                }
            }
            else
            {
                binding.errorMessage.visibility = View.VISIBLE
                binding.errorMessage.text = getString(com.tainka.bangku.R.string.wrongKeyLength)
            }
        }
        return binding.root
    }
}