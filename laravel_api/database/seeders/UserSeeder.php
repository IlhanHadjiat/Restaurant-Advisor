<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class UserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('users')->insert([
            'username' => "Fullmetal",
            'email' => "edward.elric@amestris.com",
            'name' => "Elric",
            'firstname' => "Edward",
            'age' => 19,
            'password' => 'a',
        ]);

        DB::table('users')->insert([
            'username' => "SirCaribou",
            'email' => "gillop_f@etna-alternance.net",
            'name' => "Gilloppé-Boulet",
            'firstname' => "Freddy",
            'age' => 19,
            'password' => 'a',
        ]);

        DB::table('users')->insert([
            'username' => "Risotto",
            'email' => "hadjia_i@etna-alternance.net",
            'name' => "Hadjiat",
            'firstname' => "Ilhan",
            'age' => 18,
            'password' => 'a',
        ]);
    }
}
