<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class MenuSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('menus')->insert([
            'name' => "Menu Maxi Best Of Big Mac",
            'description' => "Big Mac + frites + boisson",
            'price' => 10,
            'restaurant_id' => 1,
        ]);

        DB::table('menus')->insert([
            'name' => "Menu Maxi Best Of Filet O Fish",
            'description' => "Filet O Fish + frites + boisson",
            'price' => 8,
            'restaurant_id' => 1,
        ]);

        DB::table('menus')->insert([
            'name' => "Boissons",
            'description' => "Boisson chaude au choix",
            'price' => 4.5,
            'restaurant_id' => 2,
        ]);

        DB::table('menus')->insert([
            'name' => "Food",
            'description' => "Patisseries ou sandwiches au choix",
            'price' => 5,
            'restaurant_id' => 2,
        ]);

        DB::table('menus')->insert([
            'name' => "Riz Poulet",
            'description' => "Poulet au curry + Riz coco + boisson",
            'price' => 10,
            'restaurant_id' => 3,
        ]);

        DB::table('menus')->insert([
            'name' => "Nouilles Poulet",
            'description' => "Poulet Frit + Nouilles sautées + boisson",
            'price' => 10,
            'restaurant_id' => 3,
        ]);
    }
}
