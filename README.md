# Jusztina's Restaurants

<p> This application shows some restaurants and it's datas, using a free api (https://ratpark-api.imok.space/) for getting datas with Retrofit. This datas will save it to a local database, implemeted with Room database. </p>


<p>The Jusztina's Restaurants app contains a <b>splash screen </b>, <b>main screen</b>, <b>detail screen</b> and <b> profile screen</b>. </p>

<p> For these screens i used some components : activity(MainActivity),Fragments, Recycler View, Room , Constraint and Linear layout,Retrofit. </p>


### Splash Screen

<p> The data from api is loaded here. When the screen is loaded , it will automatically navigate to the next screen and that is <b>Main </b>screen with restaurants list. </p>


### Main Screen

Here is loaded the list with the restaurants.You can do text search by city. After loaded the list if you clicked to one of restaurants will be navigated to <b>Detail</b> screen

### Detail Screen

In this screen is showed all details of selected restaurant.
