<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\User;
use Illuminate\Support\Facades\Validator;

class UserController extends Controller
{
    function register(Request $request){ //Inscription      DONE
        $validator = Validator::make($request->all(), [
            'username' => 'required',
            'email' => 'required',
            'name' => 'required',
            'firstname' => 'required',
            'age' => 'required',
            'password' => 'required'
        ]);

        if ($validator->fails()){
            return response()->json(['Message' => 'Account not created : A field is missing.'], 400);
        } else {
            $user = User::CreateDTOtoObject($request);

            $user->save();

            return response($user, 201);
        }
    }

    function auth(Request $request){ //Authentification     DONE
        $email = $request->email;
        $password = $request->password;

        User::getUserFromName($email);
        if (md5 ($password) == $email->password){
            return response()->json(['message' => "Welcome back :)"], 200);
        } else {
            return response()->json(['message' => "Wrong password or email."], 400);
        }
    }

    function getAll(){ //Avoir une liste d’utilisateurs     DONE
        return User::all();
    }
}
