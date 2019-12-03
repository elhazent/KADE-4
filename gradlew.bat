import 'package:flutter/material.dart';
import 'package:pln_marketplace/category-model.dart';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xfff0f0f0),
      body: SingleChildScrollView(
        scrollDirection: Axis.vertical,
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            category(),
            Padding(
              padding: const EdgeInsets.only(right: 4.0, left: 4.0, top: 10),
              child: SingleChildScrollView(
                child: itemCategory(CategoryModel.getItemCount),
                scrollDirection: Axis.horizontal,
              ),
            ),
            SizedBox(height: 10,),
            product(),
            recommended()
          ],
        ),
      ),
    );
  }
}

Widget category() {
  Color blue = Color(0xff09e2e7);
  return Padding(
    padding:
    const EdgeInsets.only(right: 20.0, left: 20.0, top: 60.0),
    child: Row(
      children: <Widget>[
        Flexible(
          child: Container(
            padding: EdgeInsets.symmetric(
              horizontal: 10,
            ),
            decoration: BoxDecoration(
                borderRadius: BorderRadius.all(Radius.circular(7)),
                color: Colors.white),
            child: TextField(
              decoration: InputDecoration(
                hintText: 'Apa yang Anda cari',
                hintStyle:
                TextStyle(fontSize: 20.0, color: Colors.grey),
                border: InputBorder.none,
                prefixIcon: Icon(
                  Icons.search,
                  size: 26.0,
                  color: Colors.grey,
                ),
              ),
            ),
          ),
          flex: 10,
        ),
        Flexible(
          child: Container(
              margin: EdgeInsets.all(10),
              child: Icon(
                Icons.notifications_none,
                color: blue,
                size: 30,
              )),
          