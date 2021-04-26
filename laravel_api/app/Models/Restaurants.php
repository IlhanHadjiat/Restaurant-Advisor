<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Http\Request;

class Restaurants extends Model
{
    use HasFactory;

    public static function CreateDTOtoObject(Request $request){
        $restaurant = new Restaurants();

        $restaurant ->name = $request->name;
        $restaurant ->description = $request->description;
        $restaurant ->grade = $request->grade;
        $restaurant ->localization = $request->localization;
        $restaurant ->phone_number = $request->phone_number;
        $restaurant ->website = $request->website;
        $restaurant ->hours = $request->hours;

        return $restaurant;
    }

    public static function UpdateDTOtoObject(Request $request, $restaurant){

        if ($restaurant->name){$restaurant ->name = $request->name;}
        if ($restaurant->description){$restaurant ->description = $request->description;}
        if ($restaurant->grade){$restaurant ->grade = $request->grade;}
        if ($restaurant->localization){$restaurant ->localization = $request->localization;}
        if ($restaurant->phone_number){$restaurant ->phone_number = $request->phone_number;}
        if ($restaurant->website){$restaurant ->website = $request->website;}
        if ($restaurant->hours){$restaurant ->hours = $request->hours;}

        return $restaurant;
    }


}
