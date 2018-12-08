package com.example.tung.ichef;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private Handler mWaitHandler = new Handler();

    Recipe recipe;

    private RecipeDBHelper tdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //this.deleteDatabase("recipeManager");
        tdb = new RecipeDBHelper(this);

        String title_1 = "Hamburger Steak with Onions and Gravy";
        String title_2 = "Bats and Cobwebs";
        String title_3 = "Three-Ingredient Baked Chicken Breasts";
        String title_4 = "Chinese Pepper Steak";

        String[] titles = {"Hamburger Steak with Onions and Gravy",
                            "Bats and Cobwebs",
                            "Three-Ingredient Baked Chicken Breasts",
                            "Chinese Pepper Steak",
                            "General Tsao's Chicken II",
                            "Baja Fish Tacos",
                            "Chilaquiles",
                            "Black Bean Burritos",
                            "Chicken Parmesan",
                            "Double Layer Pumpkin Cheesecake",
                            "Ultra Easy Pineapple and Chicken Kabobs",
                            "Pan Fried Sand Dabs",
                            "The Best Sweet and Sour Meatballs",
                            "Easy Mexican Casserole",
                            "Slow Cooker Beef Stew I",
                            "World's Best Lasagna",
                            "Loaded Crack Potatoes",
                            "Bourbon Street Rib-Eye Steak",
                            "Salsa Chicken Rice Casserole",
                            "Salisbury Steak"};

        String author_1 = "Anne Marie Sweden";
        String author_2 = "Kristin McNeil";
        String author_3 = "Jennifer Jones";
        String author_4 = "Kim Wilson";

        String[] authors = {"Anne Marie Sweden",
                            "Kristin McNeil",
                            "Jennifer Jones",
                            "Kim Wilson",
                            "ChefDaddy",
                            "Jennifer Segal",
                            "Elise Bauer",
                            null,
                            "Chef John",
                            "Stephanie Phillips",
                            "c siebester",
                            "Kathy626",
                            "KIMMY D",
                            "ANDREALF63",
                            "BUCHKO",
                            "John Chandler",
                            "Barbi",
                            "Judy Diercks OReilly",
                            "Gweneth",
                            "Kelly Berenger"};

        String[] ingredients_1 = {" - 1 pound ground beef",
                                    " - 1 egg",
                                    " - 1/4 cup bread crumbs",
                                    " - 1/8 teaspoon ground pepper",
                                    " - 1/2 teaspoon seasoned salt",
                                    " - 1/2 teaspoon onion powder",
                                    " - 1/2 teaspoon garlic powder",
                                    " - 1 teaspoon Worcestershire sauce",
                                    " - 1 tablespoon vegetable oil",
                                    " - 1 cup thinly sliced onion",
                                    " - 2 tablespoons all-purpose flour",
                                    " - 1 cup beef broth",
                                    " - 1 tablespoon cooking sherry",
                                    " - 1/2 teaspoon seasoned salt"};
        String[] ingredients_2 = {" - 1 (8 ounce) package farfalle (bow tie) pasta",
                                    " - 1 pound ground beef",
                                    " - 1 small onion, chopped (optional)",
                                    " - 1 (28 ounce) jar pasta sauce",
                                    " - 8 ounces mozzarella cheese, cut into 1/2 inch cubes",
                                    " - 1/4 cup grated Parmesan cheese"};
        String[] ingredients_3 = {" - 1/4 cup butter, melted",
                                    " - 1 teaspoon salt",
                                    " - 4 skinless, boneless chicken breast halves"};
        String[] ingredients_4 = {" - 1 pound beef top sirloin steak",
                                    " - 1/4 cup soy sauce",
                                    " - 2 tablespoons white sugar",
                                    " - 2 tablespoons cornstarch",
                                    " - 1/2 teaspoon ground ginger",
                                    " - 3 tablespoons vegetable oil, divided",
                                    " - 1 red onion, cut into 1-inch squares",
                                    " - 1 green bell pepper, cut into 1-inch squares",
                                    " - 2 tomatoes, cut into wedges"};
        String[] ingredients_5 = {" - 4 cups vegetable oil for frying",
                                    " - 1 egg",
                                    " - 1 1/2 pounds boneless, skinless chicken thighs, cut into 1/2 inch cubes",
                                    " - 1 teaspoon salt",
                                    " - 1 teaspoon white sugar",
                                    " - 1 pinch white pepper",
                                    " - 1 cup cornstarch",
                                    " - 2 tablespoons vegetable oil",
                                    " - 3 tablespoons chopped green onion",
                                    " - 1 clove garlic, minced",
                                    " - 6 dried whole red chilies",
                                    " - 1 strip orange zest",
                                    " - 1/2 cup white sugar",
                                    " - 1/4 teaspoon ground ginger",
                                    " - 3 tablespoons chicken broth",
                                    " - 1 tablespoon rice vinegar",
                                    " - 1/4 cup soy sauce",
                                    " - 2 teaspoons sesame oil",
                                    " - 2 tablespoons peanut oil",
                                    " - 2 teaspoons cornstarch",
                                    " - 1/4 cup water"};
        String[] ingredients_6 = {" - 5 cups (or one 10-ounce bag) shredded red cabbage",
                                    " - 3 tablespoons minced red onion",
                                    " - 1/2 cup fresh chopped cilantro",
                                    " - 3 tablespoons cider vinegar",
                                    " - 1 1/2 teaspoons vegetable oil",
                                    " - 1/2 teaspoon salt",
                                    " - 3/4 cup mayonnaise, best quality such as Hellmann's",
                                    " - 2 tablespoons lime juice, from one lime",
                                    " - 2-3 chipotle chiles in adobo sauce (canned), roughly chopped, plus 1-2 teaspoons sauce",
                                    " - 1 large garlic clove, roughly chopped",
                                    " - 1 cup all purpose flour",
                                    " - 1 teaspoon salt",
                                    " - 1/2 teaspoon ground black pepper",
                                    " - 1 cup beer",
                                    " - 1-1/2 pounds skinless cod, cut into 1-inch wide x 4-inch long strips",
                                    " - Vegetable oil, for frying",
                                    " - 12 (6-inch) soft corn tortillas, warmed",
                                    " - Lime wedges, for serving"};
        String[] ingredients_7 = {" - 1 dozen corn tortillas, preferably stale, or left out overnight to dry out a bit, quartered or cut into 6 wedges",
                                    " - Corn oil",
                                    " - Salt",
                                    " - 1 1/2 to 2 cups red chile sauce or salsa verde",
                                    " - A few sprigs of epazote (optional)",
                                    " - Garnishes",
                                    " - Cotija cheese or queso fresco",
                                    " - Crema Mexicana or creme fraiche",
                                    " - Cilantro, chopped",
                                    " - Chopped red onion",
                                    " - Avocado, sliced or roughly chopped"};
        String[] ingredients_8 = {" - 1 tablespoon canola oil",
                                    " - 3 tablespoons chopped onion",
                                    " - 3 tablespoons chopped green pepper",
                                    " - 1 can (15 ounces) black beans, rinsed and drained",
                                    " - 4 flour tortillas (8 inches), warmed",
                                    " - 1 cup shredded Mexican cheese blend",
                                    " - 1 cup shredded lettuce",
                                    " - 1 medium tomato, chopped",
                                    " - salsa, sour cream, minced fresh cilantro, cubed avocado, optional"};
        String[] ingredients_9 = {" - 4 skinless, boneless chicken breast halves",
                                    " - salt and freshly ground black pepper to taste",
                                    " - 2 eggs",
                                    " - 1 cup panko bread crumbs, or more as needed",
                                    " - 1/2 cup grated Parmesan cheese",
                                    " - 2 tablespoons all-purpose flour, or more if needed",
                                    " - 1 cup olive oil for frying",
                                    " - 365 Everyday Value, Extra Virgin Olive Oil, 16.9 fl",
                                    " - 1/2 cup prepared tomato sauce",
                                    " - 1/4 cup fresh mozzarella cut into small cubes",
                                    " - 1/4 cup chopped fresh basil",
                                    " - 1/2 cup grated provolone cheese",
                                    " - 1/4 cup grated Parmesan cheese",
                                    " - 1 tablespoon olive oil"};
        String[] ingredients_10 = {" - 2 (8 ounce) packages cream cheese, softened",
                                    " - 1/2 cup white sugar",
                                    " - 1/2 teaspoon vanilla extract",
                                    " - 2 eggs",
                                    " - 1 (9 inch) prepared graham cracker crust",
                                    " - 1/2 cup pumpkin puree",
                                    " - 1/2 teaspoon ground cinnamon",
                                    " - 1 pinch ground cloves",
                                    " - 1 pinch ground nutmeg",
                                    " - 1/2 cup frozen whipped topping, thawed"};
        String[] ingredients_11 = {" - 1 green bell pepper, cut into 1-inch pieces",
                                    " - 1/2 onion, cut into 1-inch pieces",
                                    " - 1/2 pound skinless, boneless chicken breast halves, cut into 1-inch pieces",
                                    " - 1 (15 ounce) can pineapple chunks, drained",
                                    " - 1/4 cup barbeque sauce, or as needed"};
        String[] ingredients_12 = {" - 1 egg beaten",
                                    " - 1/4cup milk",
                                    " - 1 pound pan-dressed Sand Dabs",
                                    " - 1/2 cup flour seasoned with salt and pepper",
                                    " - 1/2 cup breadcrumbs",
                                    " - 1/4 cup oil or clarified butter",
                                    " - Lemon wedges"};
        String[] ingredients_13 = {" - 1 pound ground beef",
                                    " - 1 egg",
                                    " - 1/4 cup dry bread crumbs",
                                    " - 1 onion, diced",
                                    " - 3 tablespoons all-purpose flour",
                                    " - 1 1/2 cups water",
                                    " - 1/4 cup distilled white vinegar",
                                    " - 3 tablespoons soy sauce",
                                    " - 1 cup packed brown sugar"};
        String[] ingredients_14 = {" - 1 pound lean ground beef",
                                    " - 2 cups salsa",
                                    " - 1 (16 ounce) can chili beans, drained",
                                    " - 3 cups tortilla chips, crushed",
                                    " - 2 cups sour cream",
                                    " - 1 (2 ounce) can sliced black olives, drained",
                                    " - 1/2 cup chopped green onion",
                                    " - 1/2 cup chopped fresh tomato",
                                    " - 2 cups shredded Cheddar cheese"};
        String[] ingredients_15 = {" - 2 pounds beef stew meat, cut into 1-inch pieces",
                                    " - 1/4 cup all-purpose flour",
                                    " - 1/2 teaspoon salt",
                                    " - 1/2 teaspoon ground black pepper",
                                    " - 1 clove garlic, minced",
                                    " - 1 bay leaf",
                                    " - 1 teaspoon paprika",
                                    " - 1 teaspoon Worcestershire sauce",
                                    " - 1 onion, chopped",
                                    " - 1 1/2 cups beef broth",
                                    " - 3 potatoes, diced",
                                    " - 4 carrots, sliced",
                                    " - 1 stalk celery, chopped"};
        String[] ingredients_16 = {" - 1 pound sweet Italian sausage",
                                    " - 3/4 pound lean ground beef",
                                    " - 1/2 cup minced onion",
                                    " - 2 cloves garlic, crushed",
                                    " - 1 (28 ounce) can crushed tomatoes",
                                    " - 2 (6 ounce) cans tomato paste",
                                    " - 2 (6.5 ounce) cans canned tomato sauce",
                                    " - 1/2 cup water",
                                    " - 2 tablespoons white sugar",
                                    " - 1 1/2 teaspoons dried basil leaves",
                                    " - 1/2 teaspoon fennel seeds",
                                    " - 1 teaspoon Italian seasoning",
                                    " - 1 tablespoon salt",
                                    " - 1/4 teaspoon ground black pepper",
                                    " - 4 tablespoons chopped fresh parsley",
                                    " - 12 lasagna noodles",
                                    " - 16 ounces ricotta cheese",
                                    " - 1 egg",
                                    " - 1/2 teaspoon salt",
                                    " - 3/4 pound mozzarella cheese, sliced",
                                    " - 3/4 cup grated Parmesan cheese"};
        String[] ingredients_17 = {" - cooking spray",
                                    " - 1 (32 ounce) package frozen hash brown potatoes, thawed",
                                    " - 1 (16 ounce) container sour cream",
                                    " - 8 slices cooked bacon, crumbled",
                                    " - 1 (1 ounce) package ranch dressing mix",
                                    " - 2 cups shredded Cheddar cheese, divided, or more to taste"};
        String[] ingredients_18 = {" - 1 cup water",
                                    " - 2/3 cup bourbon whiskey",
                                    " - 1/2 cup soy sauce",
                                    " - 1/4 cup packed brown sugar",
                                    " - 3 tablespoons Worcestershire sauce",
                                    " - 2 tablespoons lemon juice",
                                    " - 4 (6 ounce) beef rib-eye steaks"};
        String[] ingredients_19 = {" - 1 1/3 cups uncooked white rice",
                                    " - 2 2/3 cups water",
                                    " - 4 skinless, boneless chicken breast halves",
                                    " - 2 cups shredded Monterey Jack cheese",
                                    " - 2 cups shredded Cheddar cheese",
                                    " - 1 (10.75 ounce) can condensed cream of chicken soup",
                                    " - 1 (10.75 ounce) can condensed cream of mushroom soup",
                                    " - 1 onion, chopped",
                                    " - 1 1/2 cups mild salsa"};
        String[] ingredients_20 = {" - 1 (10.5 ounce) can condensed French onion soup",
                                    " - 1 1/2 pounds ground beef",
                                    " - 1/2 cup dry bread crumbs",
                                    " - 1 egg",
                                    " - 1/4 teaspoon salt",
                                    " - 1/8 teaspoon ground black pepper",
                                    " - 1 tablespoon all-purpose flour",
                                    " - 1/4 cup ketchup",
                                    " - 1/4 cup water",
                                    " - 1 tablespoon Worcestershire sauce",
                                    " - 1/2 teaspoon mustard powder"};

        String[][] ingredients = {ingredients_1,ingredients_2,ingredients_3,ingredients_4,ingredients_5,ingredients_6,ingredients_7,ingredients_8,ingredients_9,ingredients_10,ingredients_11,ingredients_12,ingredients_13,ingredients_14,ingredients_15,ingredients_16,ingredients_17,ingredients_18,ingredients_19,ingredients_20};

        String direction_1 = "    - In large bowl, mix together the ground beef, egg, bread crumbs, pepper, salt, onion powder, garlic powder, and Worcestershire sauce. Form into 8 balls, and flatten into patties." +
                "\n\n    - Heat the oil in a large skillet over medium heat. Fry the patties and onion in the oil until patties are nicely browned, about 4 minutes per side. Remove the beef patties to a plate, and keep warm." +
                "\n\n    - Sprinkle flour over the onions and drippings in the skillet. Stir in flour with a fork, scraping bits of beef off of the bottom as you stir. Gradually mix in the beef broth and sherry. Season with seasoned salt. Simmer and stir over medium-low heat for about 5 minutes, until the gravy thickens. Turn heat to low, return patties to the gravy, cover, and simmer for another 15 minutes.";
        String direction_2 = "    - Preheat oven to 400 degrees F (200 degrees C)." +
                "\n\n    - Fill a large pot with lightly salted water, bring to a rolling boil over high heat. Stir in the bow tie pasta and return to a boil. Boil pasta, stirring occasionally, until cooked through but still firm to the bite, about 12 minutes. Brain well." +
                "\n\n    - Cook and stir ground beef and onion in a large skillet until beef is no longer pink, about 5 minutes. Drain fat. Stir in pasta sauce and bring to a boil. Reduce heat to simmer." +
                "\n\n    - Stir cooked pasta and half of the mozzarella cheese into the sauce; toss to combine. Transfer to a 2-quart baking dish. Top with remaining mozzarella and Parmesan cheese." +
                "\n\n    - Bake in preheated oven until lightly browned and bubbly, 15 to 20 minutes.";
        String direction_3 = "    - Preheat oven to 350 degrees F (175 degrees C). Lightly butter a baking dish." +
                "\n\n    - Stir 1/4 cup melted butter and salt together in a bowl." +
                "\n\n    - Arrange chicken in the baking dish. Brush butter mixture onto the chicken until thoroughly coated, pouring any extra over the chicken." +
                "\n\n    - Bake in the preheated oven until no longer pink in the center and the juices run clear, about 30 to 45 minutes. An instant-read thermometer inserted into the center should read at least 165 degrees F (74 degrees C).";
        String direction_4 = "    - Slice the steak into 1/2-inch thick slices across the grain." +
                "\n\n    - Whisk together soy sauce, sugar, cornstarch, and ginger in a bowl until the sugar has dissolved and the mixture is smooth. Place the steak slices into the marinade, and stir until well-coated." +
                "\n\n    - Heat 1 teaspoon of vegetable oil in a wok or large skillet over medium-high heat, and place 1/3 of the steak strips into the hot oil. Cook and stir until the beef is well-browned, about 3 minutes, and remove the beef from the wok to a bowl. Repeat twice more, with the remaining beef, and set the cooked beef aside." +
                "\n\n    - Return all the cooked beef to the hot wok, and stir in the onion. Toss the beef and onion together until the onion begins to soften, about 2 minutes, then stir in the green pepper. Cook and stir the mixture until the pepper has turned bright green and started to become tender, about 2 minutes, then add the tomatoes, stir everything together, and serve.";
        String direction_5 = "    - Heat 4 cups vegetable oil in a deep-fryer or large saucepan to 375 degrees F (190 degrees C)." +
                "\n\n    - Beat the egg in a mixing bowl. Add the chicken cubes; sprinkle with salt, 1 teaspoon sugar, and white pepper; mix well. Mix in 1 cup of cornstarch a little bit at a time until the chicken cubes are well coated." +
                "\n\n    - In batches, carefully drop the chicken cubes into the hot oil one by one, cooking until they turns golden brown and begin to float, about 3 minutes. Remove the chicken and allow to cool as you fry the next batch. Once all of the chicken has been fried, refry the chicken, starting with the batch that was cooked first. Cook until the chicken turns deep golden brown, about 2 minutes more. Drain on a paper towel-lined plate." +
                "\n\n    - Heat 2 tablespoons vegetable oil in a wok or large skillet over high heat. Stir in the green onion, garlic, whole chiles, and orange zest. Cook and stir a minute or two until the garlic has turned golden and the chiles brighten. Add 1/2 cup sugar, the ginger, chicken broth, vinegar, soy sauce, sesame oil, and peanut oil; bring to a boil and cook for 3 minutes." +
                "\n\n    - Dissolve 2 teaspoons of cornstarch into the water, and stir into the boiling sauce. Return to a boil and cook until the sauce thickens and is no longer cloudy from the cornstarch, about 1 minute. Stir the chicken into the boiling sauce. Reduce heat to low and cook for a few minutes until the chicken absorbs some of the sauce.";
        String direction_6 = "    - Toss the cabbage, red onion, cilantro, vinegar, oil and salt together in a medium bowl and set aside." +
                "\n\n    - Combine the mayonnaise, lime juice, chipotle chiles with sauce and garlic in a blender or mini food processor and blend until smooth. Set aside." +
                "\n\n    - Mix the flour, salt and pepper together in a medium bowl. Gradually add the beer, whisking until the batter is smooth with no lumps. Set aside." +
                "\n\n    - In a medium skillet, over medium heat, add enough oil to reach a depth of 1/2-inch. Heat the oil until a deep-fry thermometer registers 350 degrees F, or when the end of a wooden spoon sizzles when dipped into the oil." +
                "\n\n    - Working in batches so as not to crowd the pan, dip the fish strips in the beer batter and coat on both sides. Let the excess batter drip off, then fry the fish in the hot oil until golden brown and cooked through, about 2 minutes per side. Transfer to a plate lined with paper towels to drain." +
                "\n\n    - Smear each tortilla with a generous amount of the chipotle sauce, then top with the cabbage slaw. Lay one piece of fish inside each tortilla and serve with lime wedges." +
                "\n\n    - Note: 3 chipotle peppers and 2 teaspoons sauce will give you a spicy sauce. Use less for a milder sauce. You can freeze any leftover chipotle peppers from the can." +
                "\n\n    - Note: Nutritional information was calculated assuming that approximately 3 tablespoons of oil are absorbed into the fish when fried." +
                "\n\n    - Note: Nutritional Information does not include the chipotle sauce.";
        String direction_7 = "1. Fry the tortillas:" +
                "\n    - In a large sauté pan, coat pan generously with corn oil, (1/8 inch), heat on medium high to high. When the oil is quite hot, add the tortillas, fry until golden brown." +
                "\n    - Remove tortillas to a paper towel lined plate to soak up excess oil. Sprinkle a little salt on the tortillas." +
                "\n    - Wipe pan clean of any browned bits of tortillas." +
                "\n\n 2. Heat the salsa:" +
                "\n    - Add 2 Tbsp oil to pan, bring to high heat again. Add the salsa and let salsa cook for several minutes. If you have a few sprigs of epazote, add them to the salsa." +
                "\n\n 3. Add fried tortillas to the salsa:" +
                "\n    - Add the fried tortilla quarters to the salsa. Gently turn over the pieces of tortilla until they are all well coated with salsa. Let cook for a few minutes more." +
                "\n    - Remove from heat. Serve chilaquiles with garnishes and fried eggs and beans or nopalitos.";
        String direction_8 = "    - In a nonstick skillet heat oil over medium heat; saute onion and green pepper until tender. Stir in beans; heat through." +
                "\n\n    - Spoon about 1/2 cupful off center on each tortilla. Sprinkle with the cheese, tomato and lettuce. Fold sides and ends over filling and roll up. Serve with salsa, sour cream, cilantro and avocado if desired.";
        String direction_9 = "    - Preheat an oven to 450 degrees F (230 degrees C)." +
                "\n\n    - Place chicken breasts between two sheets of heavy plastic (resealable freezer bags work well) on a solid, level surface. Firmly pound chicken with the smooth side of a meat mallet to a thickness of 1/2-inch. Season chicken thoroughly with salt and pepper." +
                "\n\n    - Beat eggs in a shallow bowl and set aside." +
                "\n\n    - Mix bread crumbs and 1/2 cup Parmesan cheese in a separate bowl, set aside." +
                "\n\n    - Place flour in a sifter or strainer; sprinkle over chicken breasts, evenly coating both sides." +
                "\n\n    - Dip flour coated chicken breast in beaten eggs. Transfer breast to breadcrumb mixture, pressing the crumbs into both sides. Repeat for each breast. Set aside breaded chicken breasts for about 15 minutes." +
                "\n\n    - Heat 1 cup olive oil in a large skillet on medium-high heat until it begins to shimmer. Cook chicken until golden, about 2 minutes on each side. The chicken will finish cooking in the oven." +
                "\n\n    - Place chicken in a baking dish and top each breast with about 1/3 cup of tomato sauce. Layer each chicken breast with equal amounts of mozzarella cheese, fresh basil, and provolone cheese. Sprinkle 1 to 2 tablespoons of Parmesan cheese on top and drizzle with 1 tablespoon olive oil." +
                "\n\n    - Bake in the preheated oven until cheese is browned and bubbly, and chicken breasts are no longer pink in the center, 15 to 20 minutes. An instant-read thermometer inserted into the center should read at least 165 degrees F (74 degrees C).";
        String direction_10 = "    - Preheat oven to 325 degrees F (165 degrees C)." +
                "\n\n    - In a large bowl, combine cream cheese, sugar and vanilla. Beat until smooth. Blend in eggs one at a time. Remove 1 cup of batter and spread into bottom of crust; set aside." +
                "\n\n    - Add pumpkin, cinnamon, cloves and nutmeg to the remaining batter and stir gently until well blended. Carefully spread over the batter in the crust." +
                "\n\n    - Bake in preheated oven for 35 to 40 minutes, or until center is almost set. Allow to cool, then refrigerate for 3 hours or overnight. Cover with whipped topping before serving.";
        String direction_11 = "    - Preheat an outdoor grill for medium-high heat and lightly oil the grate." +
                "\n\n    - Thread green bell pepper, onion, chicken, and pineapple onto skewers; brush with barbeque sauce." +
                "\n\n    - Cook on the preheated grill until chicken is no longer pink in the center and the juices run clear, 7 to 10 minutes per side.";
        String direction_12 = "    - Beat the milk and egg together in a bowl." +
                "\n\n    - Dredge each fish in the flour, then dip them into the egg-milk mixture then roll in the breadcrumbs until thoroughly coated." +
                "\n\n    - Heat the oil or butter in a skillet over medium-high heat." +
                "\n\n    - Cook over a lively but not smoking hot fire for three to four minutes on a side until nicely golden brown on both sides." +
                "\n\n    - Serve immediately, accompanied with lemon wedges." +
                "\n\n    - If properly trimmed (see Sand Dabs under seafood info) the fish can quickly be de-boned at the table." +
                "\n\n    - Insert two forks beneath the upper filet and lift the entire filet away, leaving the bottom filet and the bones in place." +
                "\n\n    - Then, remove the skeleton, which will remain in one piece, from the bottom filet. Repeat for each fish.";
        String direction_13 = "    - In a medium bowl, combine the ground beef, egg, bread crumbs and onion. Mix thoroughly and shape into golf ball-sized balls." +
                "\n\n    - In a large skillet over medium heat, gently brown the meatballs and set aside." +
                "\n\n    - In a large saucepan, combine the brown sugar, flour, water, white vinegar and soy sauce. Mix thoroughly. Add meatballs and bring to a boil. Reduce heat and simmer, stirring often, for 30 minutes.";
        String direction_14 = "    - Preheat oven to 350 degrees F (175 degrees C)." +
                "\n\n    - In a large skillet over medium-high heat, cook ground beef until no longer pink. Stir in salsa, reduce heat, and simmer 20 minutes, or until liquid is absorbed. Stir in beans, and heat through." +
                "\n\n    - Spray a 9x13 baking dish with cooking spray. Spread crushed tortilla chips in dish, and then spoon beef mixture over chips. Spread sour cream over beef, and sprinkle olives, green onion, and tomato over the sour cream. Top with Cheddar cheese." +
                "\n\n    - Bake in preheated oven for 30 minutes, or until hot and bubbly.";
        String direction_15 = "    - Place meat in slow cooker. In a small bowl mix together the flour, salt, and pepper; pour over meat, and stir to coat meat with flour mixture. Stir in the garlic, bay leaf, paprika, Worcestershire sauce, onion, beef broth, potatoes, carrots, and celery." +
                "\n\n    - Cover, and cook on Low setting for 10 to 12 hours, or on High setting for 4 to 6 hours.";
        String direction_16 = "    - In a Dutch oven, cook sausage, ground beef, onion, and garlic over medium heat until well browned. Stir in crushed tomatoes, tomato paste, tomato sauce, and water. Season with sugar, basil, fennel seeds, Italian seasoning, 1 tablespoon salt, pepper, and 2 tablespoons parsley. Simmer, covered, for about 1 1/2 hours, stirring occasionally." +
                "\n\n    - Bring a large pot of lightly salted water to a boil. Cook lasagna noodles in boiling water for 8 to 10 minutes. Drain noodles, and rinse with cold water. In a mixing bowl, combine ricotta cheese with egg, remaining parsley, and 1/2 teaspoon salt." +
                "\n\n    - Preheat oven to 375 degrees F (190 degrees C)." +
                "\n\n    - To assemble, spread 1 1/2 cups of meat sauce in the bottom of a 9x13 inch baking dish. Arrange 6 noodles lengthwise over meat sauce. Spread with one half of the ricotta cheese mixture. Top with a third of mozzarella cheese slices. Spoon 1 1/2 cups meat sauce over mozzarella, and sprinkle with 1/4 cup Parmesan cheese. Repeat layers, and top with remaining mozzarella and Parmesan cheese. Cover with foil: to prevent sticking, either spray foil with cooking spray, or make sure the foil does not touch the cheese." +
                "\n\n    - Bake in preheated oven for 25 minutes. Remove foil, and bake an additional 25 minutes. Cool for 15 minutes before serving.";
        String direction_17 = "    - Preheat oven to 350 degrees F (175 degrees C). Grease a 13X9-inch baking pan with cooking spray or butter." +
                "\n\n    - Combine hash browns, sour cream, bacon, ranch mix, and 1 cup Cheddar cheese in a large bowl; stir until well mixed. Spread into baking pan; cover with aluminum foil." +
                "\n\n    - Bake in the preheated oven for 45 minutes. Remove foil; sprinkle remaining Cheddar cheese evenly across potatoes. Bake until cheese is bubble and lightly browned around the edges, about 15 minutes.";
        String direction_18 = "    - Whisk together the water, bourbon whiskey, soy sauce, brown sugar, Worcestershire sauce, and lemon juice in a bowl, and pour into a plastic zipper bag. Add the rib-eye steaks, coat with the marinade, squeeze out excess air, and seal the bag. Marinate in the refrigerator for 8 hours or overnight." +
                "\n\n    - Preheat an outdoor grill for high heat, and lightly oil the grate." +
                "\n\n    - Remove the rib-eye steaks from the marinade, and shake off excess. Discard the remaining marinade. Grill the steaks on high, 1 to 2 minutes per side, to sear the meat. Move the steaks to a cooler part of the grill and cook for an additional 2 to 3 minutes per side, if desired.";
        String direction_19 = "    - Place rice and water in a saucepan, and bring to a boil. Reduce heat to low, cover, and simmer for 20 minutes." +
                "\n\n    - Meanwhile, place chicken breast halves into a large saucepan, and fill the pan with water. Bring to a boil, and cook for 20 minutes, or until done. Remove chicken from water. When cool enough to handle, cut meat into bite-size pieces." +
                "\n\n    - Preheat oven to 350 degrees F (175 degrees C). Lightly grease a 9x13 inch baking dish." +
                "\n\n    - In a medium bowl, combine Monterey Jack and Cheddar cheeses. In a separate bowl, mix together cream of chicken soup, cream of mushroom soup, onion, and salsa. Layer 1/2 of the rice, 1/2 of the chicken, 1/2 of the soup and salsa mixture, and 1/2 of the cheese mixture in prepared dish. Repeat layers, ending with cheese." +
                "\n\n    - Bake in preheated oven for about 40 minutes, or until bubbly.";
        String direction_20 = "    - In a large bowl, mix together 1/3 cup condensed French onion soup with ground beef, bread crumbs, egg, salt and black pepper. Shape into 6 oval patties." +
                "\n\n    - In a large skillet over medium-high heat, brown both sides of patties. Pour off excess fat." +
                "\n\n    - In a small bowl, blend flour and remaining soup until smooth. Mix in ketchup, water, Worcestershire sauce and mustard powder. Pour over meat in skillet. Cover, and cook for 20 minutes, stirring occasionally.";

        String[] directions = {direction_1,direction_2,direction_3,direction_4,direction_5,direction_6,direction_7,direction_8,direction_9,direction_10,direction_11,direction_12,direction_13,direction_14,direction_15,direction_16,direction_17,direction_18,direction_19,direction_20};

        String reference_1 = "https://www.allrecipes.com/recipe/78370/hamburger-steak-with-onions-and-gravy/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%201";
        String reference_2 = "https://www.allrecipes.com/recipe/216231/bats-and-cobwebs/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%202";
        String reference_3 = "https://www.allrecipes.com/recipe/239137/three-ingredient-baked-chicken-breasts/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%201";
        String reference_4 = "https://www.allrecipes.com/recipe/172704/chinese-pepper-steak/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%201";

        String[] references = {"https://www.allrecipes.com/recipe/78370/hamburger-steak-with-onions-and-gravy/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%201",
                                "https://www.allrecipes.com/recipe/216231/bats-and-cobwebs/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%202",
                                "https://www.allrecipes.com/recipe/239137/three-ingredient-baked-chicken-breasts/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%201",
                                "https://www.allrecipes.com/recipe/172704/chinese-pepper-steak/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%201",
                                "https://www.allrecipes.com/recipe/91499/general-tsaos-chicken-ii/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%201/",
                                "https://www.onceuponachef.com/recipes/baja-fish-tacos.html",
                                "https://www.simplyrecipes.com/recipes/chilaquiles/",
                                "https://www.tasteofhome.com/recipes/black-bean-burritos/",
                                "https://www.allrecipes.com/recipe/223042/chicken-parmesan/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%202",
                                "https://www.allrecipes.com/recipe/13477/double-layer-pumpkin-cheesecake/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%202",
                                "https://www.allrecipes.com/recipe/234348/ultra-easy-pineapple-chicken-kabobs/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%201",
                                "https://www.epicurious.com/recipes/member/views/pan-fried-sand-dabs-50178389",
                                "https://www.allrecipes.com/recipe/26673/the-best-sweet-and-sour-meatballs/?internalSource=rotd&referringContentType=Homepage&clickId=cardslot%201",
                                "https://www.allrecipes.com/recipe/20680/easy-mexican-casserole/?internalSource=previously%20viewed&referringContentType=Homepage&clickId=cardslot%203",
                                "https://www.allrecipes.com/recipe/14685/slow-cooker-beef-stew-i/?internalSource=previously%20viewed&referringContentType=Homepage&clickId=cardslot%204",
                                "https://www.allrecipes.com/recipe/23600/worlds-best-lasagna/?internalSource=previously%20viewed&referringContentType=Homepage&clickId=cardslot%205",
                                "https://www.allrecipes.com/recipe/254811/loaded-crack-potatoes/?internalSource=previously%20viewed&referringContentType=Homepage&clickId=cardslot%207",
                                "https://www.allrecipes.com/recipe/201851/bourbon-street-rib-eye-steak/?internalSource=previously%20viewed&referringContentType=Homepage&clickId=cardslot%208",
                                "https://www.allrecipes.com/recipe/17952/salsa-chicken-rice-casserole/?internalSource=previously%20viewed&referringContentType=Homepage&clickId=cardslot%209",
                                "https://www.allrecipes.com/recipe/14595/salisbury-steak/?internalSource=previously%20viewed&referringContentType=Homepage&clickId=cardslot%2010"};

//        recipe = new Recipe(title_1,author_1,ingredients_1,direction_1,"s","no",reference_1);
//
//        tdb.addRecipe(recipe);
//        tdb.addIngredient(recipe);
//        tdb.addDirection(recipe);
//
//        recipe = new Recipe(title_2,author_2,ingredients_2,direction_2,"s","no",reference_2);
//
//        tdb.addRecipe(recipe);
//        tdb.addIngredient(recipe);
//        tdb.addDirection(recipe);
//
//        recipe = new Recipe(title_3,author_3,ingredients_3,direction_3,"s","no",reference_3);
//
//        tdb.addRecipe(recipe);
//        tdb.addIngredient(recipe);
//        tdb.addDirection(recipe);
//
//        recipe = new Recipe(title_4,author_4,ingredients_4,direction_4,"s","no",reference_4);
//
//        tdb.addRecipe(recipe);
//        tdb.addIngredient(recipe);
//        tdb.addDirection(recipe);

        for(int i = 0; i < titles.length;i++){
            recipe = new Recipe(titles[i],authors[i],ingredients[i],directions[i],"s","no",references[i]);
            tdb.addRecipe(recipe);
            tdb.addIngredient(recipe);
            tdb.addDirection(recipe);
        }

        mWaitHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try{
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception ignored){
                    ignored.printStackTrace();
                }
            }
        }, 2000);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mWaitHandler.removeCallbacksAndMessages(null);
    }
}
