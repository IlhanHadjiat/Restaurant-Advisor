<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Restaurants;
use Illuminate\Support\Facades\Validator;

class RestaurantController extends Controller
{
    function getAll(){ //Récupérer la liste des restaurants     DONE
        return Restaurants::all();
    }

    function getByID($id){ //Récupérer le restaurant correspondant à l'id donné     DONE
        return Restaurants::findOrFail($id);
    }

    function create(Request $request) { //Créer un restaurant       DONE
        $validator = Validator::make($request->all(), [
            'name' => 'required',
            'description' => 'required',
            'grade' => 'required',
            'localization' =>'required',
            'phone_number' => 'required',
            'website' => 'nullable',
            'hours' => 'required'
        ]);

        if ($validator->fails()){
            return response()->json(['Message' => 'Restaurant not created : A field is missing.'], 400);
        } else {
            $restaurant = Restaurants::CreateDTOtoObject($request);

            $restaurant->save();

            return response($restaurant, 201);
        }
    }

    function edit(Request $request, $id){ //Modifier un restaurant      DONE
        $restaurant = Restaurants::findOrFail($id);

        if ($restaurant){
            $restaurant = Restaurants::UpdateDTOtoObject($request, $restaurant);
            $restaurant->save();
            return response()->json(['Message' => 'Restaurant has been updated.'], 200);
        } else {
            return response()->json(['Message' => 'Operation failed : Restaurant does not exist.'], 400);
        }
    }

    function delete($id){ //Supprimer un restaurant     DONE
        $restaurant = Restaurants::findOrFail($id);

        if ($restaurant){
            $restaurant->delete();
            return response()->json(['Message' => 'Restaurant has been deleted.'], 200);
        } else {
            return response()->json(['Message' => 'Operation failed : Restaurant does not exist.'], 400);
        }
    }
}
