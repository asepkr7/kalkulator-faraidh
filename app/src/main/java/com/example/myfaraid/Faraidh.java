package com.example.myfaraid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Faraidh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faraidh);

        TextView mat1 =  findViewById(R.id.textViewMateri1);
        TextView mat2 =  findViewById(R.id.textViewMateri2);
        TextView mat3 =  findViewById(R.id.textViewMateri3);
        TextView mat4 =  findViewById(R.id.textViewMateri4);
        TextView mat6 =  findViewById(R.id.textViewMateri6);
        TextView mat7 =  findViewById(R.id.textViewMateri7);
        TextView mat8 =  findViewById(R.id.textViewMateri8);
        TextView mat9 =  findViewById(R.id.textViewMateri9);

        mat1.setText("Faroidh adalah bentuk jamak dari al-faridhah yang bermakna sesuatu yang diwajibkan, atau pembagian yang telah ditentukan sesuai dengan kadarnya masing-masing. Ilmu faraid adalah ilmu yang mempelajari tentang perhitungan dan tata cara pembagian harta warisan untuk setiap ahli waris berdasarkan syariat Islam. Ilmu Faroidh ini sangat penting untuk dipelajari karena dengannya bisa mencegah perselisihan-perselisihan dalam pembagian harta warisan.");
        mat2.setText("Allah swt berfirman : “Dan janganlah kamu serahkan kepada orang-orang yang belum sempurna akalnya, harta (mereka yang ada dalam kekuasaanmu) yang dijadikan Allah sebagai pokok kehidupan. Berilah mereka belanja dan pakaian (dari hasil harta itu) dan ucapkanlah kepada mereka kata-kata yang baik.” (Q.S. An-Nisaa’ : 5)");
        mat3.setText("\t1. Adanya pewaris, yaitu orang yang meninggal dunia yang meninggalkan sejumlah harta dan peninggalan lainnya yang dapat diwariskan.\n" +
                "\t2. Adanya ahli waris, yaitu seseorang atau sekelompok orang yang berhak untuk menguasai atau menerima harta peninggalan pewaris dikarenakan adanya ikatan kekerabatan (nasab) atau ikatan pernikahan, atau lainnya.\n" +
                "\t3. Adanya harta warisan, yaitu harta peninggalan milik pewaris yang ditinggalkan ketika ia wafat. Harta warisan ini dapat berbagai macam bentuk dan jenisnya, seperti uang, emas, perak, kendaraan bermotor, asuransi, komputer, peralatan elektronik, binatang ternak (seperti ayam, kambing, domba, sapi, kerbau, dan lain-lain), rumah, tanah, sawah, kebun, toko, perusahaan, dan segala sesuatu yang merupakan milik pewaris yang di dalamnya ada nilai materinya.");
        mat4.setText("\t1. Telah meninggalnya pewaris baik secara nyata maupun secara hukum.\n" +
                "\t2. Adanya ahli waris yang masih hidup secara nyata pada waktu pewaris meninggal dunia.\n" +
                "\t3. Seluruh ahli waris telah diketahui secara pasti, termasuk kedudukannya terhadap pewaris dan jumlah bagiannya masing-masing.");
        mat6.setText("\tSetiap ahli waris akan dapat bagian yang telah ditentukan. Memang sebagian menerima bagian yang sudah ditentukan tetapi ada juga yang menerima sisa dari harta setelah dibagikan. Bagian-bagian tersebut yaitu bisa 2/3, 1/3, 1/6, 1/2, 1/4 dan 1/8. Biasanya pembagian ahli waris terhadap laki-laki lebih besar dari perempuan, hal ini dikarenakan laki-laki mempunyai tanggung jawab yang besar untuk membiayai keluarganya dibandingkan dengan perempuan");
        mat7.setText("1. Asal Masalah\n" +
                "\t- Jika ahli warisnya ashobah bi nafsih maka asal masalahnya adalah sejumlah ahli waris yang ada.\n" +
                "\t- Jika ahli warisnya hanya terdiri dari ahli waris ashobah laki-laki dan perempuan, maka untuk laki-laki dua kali lipat perempuan dengan memperhatikan jumlahnya.\n" +
                "\t- Jika ahli waris hanya satu orang ahli waris ashabul furudl, atau satu orang ahli waris ashabul furudl dan satu orang 'ashabah maka asal masalahnya adalah angka penyebut bagian ahli waris yang bersangkutan.\n" +
                "\t- Jika ahli waris terdiri dari ahli waris ashabul furudl dua orang atau lebih, baik ada ahli waris 'ashabah atau tidak, maka mencari asal masalahnya dengan mencari (KPT) dari angka penyebut bagian masing-masing ahli waris.");
        mat8.setText("2. Perhitungan\n" +
                "Contoh :\n" +
                "Seseorang meninggal dunia, meninggalkan harta sebanyak Rp. 96 juta. Ahli warisnya terdiri dari istri, ibu dan 2 anak laki-laki.\n" +
                "\n" +
                "Bagian :\n" +
                "Istri = 1/6\n" +
                "Ibu = 1/8\n" +
                "2 Anak Laki-laki = Ashobah\n" +
                "\n" +
                "Asal Masalah :\n" +
                "KPT dari penyebut 1/6 dan 1/8 = 24\n" +
                "\n" +
                "Pembagian :\n" +
                "Ibu = 1/6 x 24 = 4\n" +
                "Istri = 1/8 x 24 = 3\n" +
                "2 Anak Laki-laki = 24 - 4 - 3 = 17\n" +
                "\n" +
                "Hasil :\n" +
                "Istri = 4/24 x 96jt = Rp. 16jt\n" +
                "Ibu = 3/24 x 96jt = Rp. 12jt\n" +
                "2 Anak laki-laki = 17/24 x 96jt = Rp. 68jt (Rp. 34jt/anak)");
        mat9.setText("3. Masalah Pembagian Warisan\n" +
                "\t- Masalah Aul, secara bahasa al-aul artinya bertambah. Sedangkan dalam fiqih mawaris, al-aul diartikan bagian-bagian yang harus diterima oleh ahli waris lebih banyak daripada asal masalahnya sehingga asal masalahnya harus ditambah/diubah.\n" +
                "\t- Masalah Radd, secara bahasa al-radd berarti mengembalikan. Sedangkan menurut istilah adalah membagia sisa harta warisan kepada ahli waris menurut pembagiannya masing-masing, setelah menerima bagiannya. Radd dilakukan karena setelah harta diperhitungkan untuk ahli waris, ternyata masih ada sisa harta. Sedangkan ahli waris tidak ada ashobah, maka sisa harta tersebut dibagikan kepada ahli waris yang ada, kecuali suami/istri.\n" +
                "\t- Masalah Gharawain artinya dua yang terang, yaitu dua masalah yang terang cara penyelesaiannya. Masalah tersebut adalah ketika pembagian warisan jika ahli warisnya suami, ibu, dan bapak atau istri, ibu, dan bapak.\n" +
                "\t- Masalah Musyarakah, secara kebahasaan artinya yang diserikatkan, yaitu jika ahli waris yang dalam perhitungan mawaris semestinya memperoleh warisan, tetapi tidak memperoleh, maka disyarikatkan kepada ahli waris yang memperoleh bagian.Masalah musyarakah ini terjadi jika ahli waris terdiri dari suami, ibu, 2 orang saudara seibu dan saudara laki-laki kandung.\n" +
                "\t- Masalah Akdariyyah artinya mengeruhkan atau menyusahkan, yaitu kakek yang menyusahkan saudara perempuan dalam bagian warisan. Dalam Masalah akdariyyah ini terjadi ketika ada orang yang meninggal dengan meninggalkan ahli waris yang terdiri dari suami, ibu, saudara perempuan kandung/sebapak dan kakek.\n" +
                "\t- Masalah irtsu al-haml, merupakan masalah pada anak yang masih dalam kandungan jika ditinggalkan ayahnya merupakan masalah yang belum dapat dipastikan jika dikaitkan dengan masalah mawaris.\n" +
                "\t- Masalah irtsu al-mafqud, yaitu masalah bagian waris yang hilang, dan maksud hilang disini adalah orang yang tidak lagi diketahui keberadaannya dalam jangka waktu yang relatif lama (maksimal 2 tahun). Tidak diketahui beritanya, dimana tempat tinggalnya dan tidak diketahui apakah dia masih hidup atau sudah meninggal.");

        ImageButton btnback =  findViewById(R.id.back);
        btnback.setOnClickListener(v -> finish());
    }

}
