# RTVR
# RottonTomatoMovieApp  &mdash; Movie Reviewer

The Rotten Tomatoes API provides access to Rotten Tomatoes' ratings and reviews, allowing you to build applications and widgets enriched with Rotten Tomatoes data.

## About Rotton Tomatos:
Some of the things the user can do are as follows

1. Access Rotten Tomatoes Critic and Audience ratings and review snippets.
2. Get listings for movies that are opening soon and currently in theaters.
3. Get listings for movies that are releasing soon and currently available on DVD or streaming.

## Initial Setup
Go to http://developer.rottentomatoes.com/ and create a new account. 
After creating an account, you will receive an email from rotten tomatoes you need to confirm your account by clicking on the link in the received email.
Click on My Account, it will display your new app and display the key which is required to be passed when you want to access the rotten tomatoes api. 

## Getting Started

### Clone the Repository
As usual, you get started by cloning the project to your local machine:
### Open and Run Project in Eclipse ADT

Now that you have cloned the repo:

1. Import the project up in Eclipse ADT  &mdash; File -> Import -> "Existing Projects into your workspace"
This App is built to work with Android API 19(KitKat). **However**, the minimum SDK support is 8(Froyo).

Now the app is ready to be used. It app can be installed on an android mobile device. 

The first activity contains a listview to show the Box Office Movies, In Theater Movies, Opening Movies and Upcoming Movies. Clicking on any one of these will populate another list view containing the movie names along with movie poster thumbnail, title, year, and MPAA rating etc.
Clicling on any of the movie will take you to the next intent which displays more information about the movie. It also gives Audience rating and Critics rating.
There is an icon present which when pressed will redirect you to your web browser and open the movie details in the web browser.

