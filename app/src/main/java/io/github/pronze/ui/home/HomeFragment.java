package io.github.pronze.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.UUID;

import io.github.pronze.R;
import io.github.pronze.SettingsActivity;
import io.github.pronze.databinding.FragmentHomeBinding;
import io.github.pronze.ui.home.recycler.BookItem;
import io.github.pronze.ui.home.recycler.ContinueReadingRecyclerAdapter;
import io.github.pronze.ui.home.recycler.LibraryBookRecyclerAdapter;

public class HomeFragment extends Fragment implements PopupMenu.OnMenuItemClickListener {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.moreButton.setOnClickListener(this::showPopup);

        RecyclerView libraryRecycler = binding.libraryRecycler;
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        libraryRecycler.setLayoutManager(layoutManager);
        libraryRecycler.setHasFixedSize(true);
        LibraryBookRecyclerAdapter adapter = new LibraryBookRecyclerAdapter(new WeakReference<>(requireActivity()));
        libraryRecycler.setAdapter(adapter);

        adapter.addItem(new BookItem("Green Radio Communication Networks", "https://images-na.ssl-images-amazon.com/images/I/51fXpLo7NoL._SX348_BO1,204,203,200_.jpg", null, "The importance of reducing energy costs, reducing CO2 emissions and protecting the environment are leading to an increased focus on green, energy-efficient approaches to the design of next-generation wireless networks. Presenting state-of-the-art research on green radio communications and networking technology by leaders in the field, this book is invaluable for researchers and professionals working in wireless communication. Summarizing existing and ongoing research, the book explores communication architectures and models, physical communications techniques, base station power-management techniques, wireless access techniques for green radio networks, and green radio test-bed, experimental results and standardization activities. Throughout, theoretical results are blended with practical insights and coverage of deployment issues. It serves as a one-stop reference for key concepts and design techniques for energy-efficient communications and networking and provides information essential for the design of future-generation cellular wireless systems."));
        adapter.addItem(new BookItem("A First Course in Network Science", "https://assets.cambridge.org/97811084/71138/cover/9781108471138.jpg", null, "Networks are everywhere: networks of friends, transportation networks and the Web. Neurons in our brains and proteins within our bodies form networks that determine our intelligence and survival. This modern, accessible textbook introduces the basics of network science for a wide range of job sectors from management to marketing, from biology to engineering, and from neuroscience to the social sciences. Students will develop important, practical skills and learn to write code for using networks in their areas of interest - even as they are just learning to program with Python. Extensive sets of tutorials and homework problems provide plenty of hands-on practice and longer programming tutorials online further enhance students' programming skills. This intuitive and direct approach makes the book ideal for a first course, aimed at a wide audience without a strong background in mathematics or computing but with a desire to learn the fundamentals and applications of network science."));
        adapter.addItem(new BookItem("Entrepreneurial Finance", "https://images-na.ssl-images-amazon.com/images/I/51gevRkgvYL._SX398_BO1,204,203,200_.jpg", null, "Academics and practitioners from a range of institutions across Europe provide a cutting-edge, practical, and comprehensive review on the financing of entrepreneurial ventures. From sourcing and obtaining funds, to financial tools for growing and managing the financial challenges and opportunities of the startup, Entrepreneurial Finance: The Art and Science of Growing Ventures is an engaging text that will equip entrepreneurs, students and early-stage investors to make sound financial decisions at every stage of a business' life. Largely reflecting European businesses and with a European perspective, the text is grounded in sound theoretical foundations. Case studies and success stories, as well as perspectives from the media and from experts, provide real-world applications, while a wealth of activities give students abundant opportunities to apply what they have learned. A must-have text for both graduate and undergraduate students in entrepreneurship, finance and management programs, as well as aspiring entrepreneurs in any field."));
        adapter.addItem(new BookItem("Phantoms of Remembrance", "https://books.google.ae/books/content?id=rpGlDWR6T0EC&printsec=frontcover&img=1&zoom=1&edge=curl&imgtk=AFLRE71f_sFF9SKzCC3hIYmlR_L-VVHgbn1iFiMADIpiw8bMjKrvvKkz4Jfel7NhKIHn6m-3w0opv7Zd25rDdeGUfBo833H5nefHCYUmpyUQXZ6a4WHtSs133Vdbuu1-I-eYWtp6PmnW", null, "In Phantoms of Remembrance, Patrick Geary makes important new inroads into the widely discussed topic of historical memory, vividly evoking the everyday lives of eleventh-century people and both their written and nonwritten ways of preserving the past. Women praying for their dead, monks creating and re-creating their archives, scribes choosing which royal families of the past to applaud and which to forget: it is from such sources that most of our knowledge of the medieval period comes. Throughout richly detailed descriptions of various acts of remembrance--including the naming of children and the recording of visions--the author unearths a wide range of approaches to preserving the past as it was or formulating the past that an individual or group prefers to imagine."));

        RecyclerView continueReadingRecycler = binding.continueReadingRecycler;
        continueReadingRecycler.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        continueReadingRecycler.setHasFixedSize(false);
        ContinueReadingRecyclerAdapter continueReadingRecyclerAdapter = new ContinueReadingRecyclerAdapter(new WeakReference<>(requireActivity()));
        continueReadingRecycler.setAdapter(continueReadingRecyclerAdapter);

        continueReadingRecyclerAdapter.addItem(new BookItem("Roman Architecture and Urbanism: From the Origins to Late Antiquity", "https://images-na.ssl-images-amazon.com/images/I/41VyVr37GeL._SX371_BO1,204,203,200_.jpg", "Since antiquity, Roman architecture and planning have inspired architects and designers. In this volume, Diane Favro and Fikret Yegül offer a comprehensive history and analysis of the Ro..", "Since antiquity, Roman architecture and planning have inspired architects and designers. In this volume, Diane Favro and Fikret Yegül offer a comprehensive history and analysis of the Roman built environment, emphasizing design and planning aspects of buildings and streetscapes. They explore the dynamic evolution and dissemination of architectural ideas, showing how local influences and technologies were incorporated across the vast Roman territory. They also consider how Roman construction and engineering expertise, as well as logistical proficiency, contributed to the making of bold and exceptional spaces and forms. Based on decades of first-hand examinations of ancient sites throughout the Roman world, from Britain to Syria, the authors give close accounts of many sites no longer extant or accessible. Written in a lively and accessible manner, Roman Architecture and Urbanism affirms the enduring attractions of Roman buildings and environments and their relevance to a global view of architecture. It will appeal to readers interested in the classical world and the history of architecture and urban design, as well as wide range of academic fields. With 835 illustrations including numerous new plans and drawings as well as digital renderings."));
        continueReadingRecyclerAdapter.addItem(new BookItem("Camille Saint-Saëns and His World", "https://images-na.ssl-images-amazon.com/images/I/31BcafdAIxS._SX329_BO1,204,203,200_.jpg", "Camille Saint-Saens--perhaps the foremost French musical figure of the late nineteenth century and a composer who wrote in nearly every musical genre, from opera and the symphony to film music--is now being rediscovered after a century of modernism overshadowed his earli...", "Camille Saint-Saens--perhaps the foremost French musical figure of the late nineteenth century and a composer who wrote in nearly every musical genre, from opera and the symphony to film music--is now being rediscovered after a century of modernism overshadowed his earlier importance. In a wide-ranging and trenchant series of essays, articles, and documents, Camille Saint-Saens and His World deconstructs the multiple realities behind the man and his music. Topics range from intimate glimpses of the private and playful Saint-Saens, to the composer's interest in astronomy and republican politics, his performances of Mozart and Rameau over eight decades, and his extensive travels around the world. This collection also analyzes the role he played in various musical societies and his complicated relationship with such composers as Liszt, Massenet, Wagner, and Ravel. Featuring the best contemporary scholarship on this crucial, formative period in French music, Camille Saint-Saens and His World restores the composer to his vital role as innovator and curator of Western music. The contributors are Byron Adams, Leon Botstein, Jean-Christophe Branger, Michel Duchesneau, Katharine Ellis, Annegret Fauser, Yves Gerard, Dana Gooley, Carolyn Guzski, Carol Hess, D. Kern Holoman, Leo Houziaux, Florence Launay, Stephane Leteure, Martin Marks, Mitchell Morris, Jann Pasler, William Peterson, Michael Puri, Sabina Teller Ratner, Laure Schnapper, Marie-Gabrielle Soret, Michael Stegemann, and Michael Strasser."));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(continueReadingRecycler.getContext(),
                LinearLayoutManager.VERTICAL);
        continueReadingRecycler.addItemDecoration(dividerItemDecoration);

        return binding.getRoot();
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(requireContext(), v);
        popup.setOnMenuItemClickListener(this);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.overflow_menu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.Settings) {
            startActivity(new Intent(requireActivity(), SettingsActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK));
            return true;
        }
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}