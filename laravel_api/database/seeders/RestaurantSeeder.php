<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class RestaurantSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('restaurants')->insert([
            'name' => "MacDonald's",
            'description' => "Classic, long-running fast-food chain known for its burgers, fries & shakes.",
            'grade' => "3.2",
            'localization' => "Centre Commercial Grand Ciel, 30 Boulevard Paul Vaillant Couturier, 94200 Ivry-sur-Seine",
            'phone_number' => "01 49 60 62 60",
            'website' => "macdonalds.fr",
            'hours' => "Monday-Saturday 9AM–9PM, Sunday Closed"
        ]);

        DB::table('restaurants')->insert([
            'name' => "Starbucks Coffee",
            'description' => "Coffee and hot chocolate.",
            'grade' => "4.0",
            'localization' => "5 Rue François Mitterrand, 94200 Ivry-sur-Seine",
            'phone_number' => "01 44 87 87 00",
            'website' => "starbucks.fr",
            'hours' => "Monday-Friday 8AM–5PM, Weekend Closed"
        ]);

        DB::table('restaurants')->insert([
            'name' => "Coco Thaï",
            'description' => "Thai restaurant known for its delicious fried chicken and its coco-rice.",
            'grade' => "4.2",
            'localization' => "5 Rue Lénine, 94200 Ivry-sur-Seine",
            'phone_number' => "09 84 27 84 45",
            'website' => "cocothai.fr",
            'hours' => "11AM-2PM, 6PM-11PM"
        ]);
    }
}
