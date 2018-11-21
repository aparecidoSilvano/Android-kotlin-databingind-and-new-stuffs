package com.example.aparecido.viewmodelexample.view.ativity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.example.aparecido.viewmodelexample.R
import com.example.aparecido.viewmodelexample.adapter.SectionsPagerAdapter
import com.example.aparecido.viewmodelexample.view.fragment.SignUpPersonalFragment
import kotlinx.android.synthetic.main.activity_sign_up.*
import me.iwf.photopicker.PhotoPicker

class SignUpActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setSupportActionBar(toolbar)

        // todo pesquisar sobre os métodos abaixo
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        /**
         * Cria o adapter que vai retornar um fragment para cada uma das três
         * seções da atividade
         */
        mSectionsPagerAdapter =
                SectionsPagerAdapter(this, supportFragmentManager)

        /* Configurando o ViewPager com as seções do adapter. */
        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }


    /* O onStart() está sendo utilizado, pois a definição de título de Toolbar ainda no onCreate() não tem efeito algum. */
    override fun onStart() {
        super.onStart()
        toolbar.title = resources.getString(R.string.title_activity_sign_up)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK
                && requestCode == PhotoPicker.REQUEST_CODE) {

            if (data != null) {
                val photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS)
                val fragment = supportFragmentManager
                        .findFragmentByTag("android:switcher:${container.id}:${mSectionsPagerAdapter?.getItemId(0)}")
                        as SignUpPersonalFragment

                fragment.updatePhoto(photos[0])
            }
        }
    }

}