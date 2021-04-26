<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Menus;
use Illuminate\Support\Facades\Validator;

class MenuController extends Controller
{
    function getAll(){ //Récupérer la liste des menus       DONE
        return Menus::all();
    }

    function getByID($id){ //Récupérer le menu correspondant à l'id donné       DONE
        return Menus::findOrFail($id);
    }

    function getAllFromRestaurant($id){ //Récupérer les menus d'un restaurant       DONE
        return (Menus::where('restaurant_id', $id)->get());
    }

    function create(Request $request) { //Créer un menu pour un restaurant      DONE
        $validator = Validator::make($request->all(), [
            'name' => 'required',
            'description' => 'required',
            'price' => 'required',
            'restaurant_id' =>'required',
        ]);

        if ($validator->fails()){
            return response()->json(['Message' => 'Menu not created : A field is missing.'], 400);
        } else {
            $menu = Menus::CreateDTOtoObject($request);

            $menu->save();

            return response($menu, 201);
        }
    }

    function edit(Request $request, $id){ //Modifier un menu        DONE
        $menu = Menus::findOrFail($id);

        if ($menu){
            $menu = Menus::UpdateDTOtoObject($request, $menu);
            $menu->save();
            return response()->json(['Message' => 'Menu has been updated.'], 200);
        } else {
            return response()->json(['Message' => 'Operation failed : Menu does not exist.'], 400);
        }
    }

    function delete($id){   //Supprimer un menu     DONE
        $menu = Menus::findOrFail($id);

        if ($menu){
            $menu->delete();
            return response()->json(['Message' => 'Menu has been deleted.'], 200);
        } else {
            return response()->json(['Message' => 'Operation failed : Menu does not exist.'], 400);
        }
    }
}
