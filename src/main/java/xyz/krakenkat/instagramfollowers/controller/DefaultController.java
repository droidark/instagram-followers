package xyz.krakenkat.instagramfollowers.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DefaultController {

    private final String selector = "span._ap3a._aaco._aacw._aacx._aad7._aade";
    private final String followingSelector = "span._ap3a._aaco._aacw._aacx._aad7._aade";
    @GetMapping
    public List<String> retrieveFollowers() throws IOException {
        File in = new File("D:\\Code\\IdeaProjects\\instagram-followers\\src\\main\\resources\\templates\\followers.html");
        Document document = Jsoup.parse(in, "UTF-8");
        Elements elements = document.select(selector);

        File inz = new File("D:\\Code\\IdeaProjects\\instagram-followers\\src\\main\\resources\\templates\\following.html");
        Document doc = Jsoup.parse(inz, "UTF-8");
        Elements elems = doc.select(followingSelector);

        List<String> followers = elements.stream().map(Element::text).toList();
        List<String> following = elems.stream().map(Element::text).toList();

        List<String> whiteList = List.of(
                "ethan136_rai",
                "walidashrafart",
                "gabrielvdesenhos",
                "kiyoshinakauchi",
                "aderiaka",
                "atom.of.art",
                "hito_komoru",
                "nejj_elle",
                "zach.lieberman",
                "kevin_bayashi",
                "merdyy_",
                "choukri.art",
                "sciamano240",
                "artgerm",
                "asashi_draws",
                "ch.juss",
                "polarts_iv",
                "katoriarts",
                "ladowska",
                "drake_otaku_artist",
                "douyart_.d",
                "chommang"
        );

        List<String> filterList = following.stream().filter(f -> !followers.contains(f)).toList();
        return filterList.stream().filter(f -> !whiteList.contains(f)).toList();
    }

    @GetMapping("/comicorp")
    public List<String> retrieveFollowersComicorp() throws IOException {
        File in = new File("D:\\Code\\IdeaProjects\\instagram-followers\\src\\main\\resources\\templates\\followers.html");
        Document document = Jsoup.parse(in, "UTF-8");
        Elements elements = document.select(selector);

        File inz = new File("D:\\Code\\IdeaProjects\\instagram-followers\\src\\main\\resources\\templates\\following.html");
        Document doc = Jsoup.parse(inz, "UTF-8");
        Elements elems = doc.select(followingSelector);

        List<String> followers = elements.stream().map(Element::text).toList();
        List<String> following = elems.stream().map(Element::text).toList();

        List<String> whiteList = List.of(
                "editorial_kamite",
                "paninicomicsmx",
                "thevaultcomics",
                "kamite_manga",
                "paninimangamx",
                "dcofficial",
                "kodanshamanga",
                "ramosland",
                "valiantentertainment",
                "darkhorsecomics",
                "imagecomics",
                "vizmedia",
                "mangalinemx",
                "marvel",
                "idwpublishing",
                "onipress",
                "boom_studios"
        );

        List<String> filterList = following.stream().filter(f -> !followers.contains(f)).toList();
        return filterList.stream().filter(f -> !whiteList.contains(f)).toList();
    }
}
