<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Http\Request;

class Menus extends Model
{
    protected $table = 'menus';
    use HasFactory;

    public static function CreateDTOtoObject(Request $request){
        $menu = new Menus();

        $menu ->name = $request->name;
        $menu ->description = $request->description;
        $menu ->price = $request->price;
        $menu ->restaurant_id = $request->restaurant_id;

        return $menu;
    }

    public static function UpdateDTOtoObject(Request $request, $menu){

        if ($menu->name){$menu ->name = $request->name;}
        if ($menu->description){$menu ->description = $request->description;}
        if ($menu->price){$menu ->price = $request->price;}
        if ($menu->restaurant_id){$menu ->restaurant_id = $request->restaurant_id;}

        return $menu;
    }

}
