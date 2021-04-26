<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\RestaurantController;
use App\Http\Controllers\MenuController;
use App\Http\Controllers\UserController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

//Home
Route::get('/', function () {
    return response()->json(['message'=>'Restaurant Advisor API']);
})->name('home');

//User
Route::post('/register', [UserController::class, 'register']); //Inscription
Route::post('/auth', [UserController::class, 'auth']); //Authentification
Route::get('/users', [UserController::class, 'getAll']); //Avoir une liste d’utilisateurs

//Restaurant
Route::get('/restaurants', [RestaurantController::class, 'getAll']); //Récupérer la liste des restaurants
Route::get('/restaurants/{id}', [RestaurantController::class, 'getByID']); //Récupérer le restaurant correspondant à l'id donné
Route::post('/restaurants', [RestaurantController::class, 'create']); //Créer un restaurant
Route::put('/restaurants/{id}', [RestaurantController::class, 'edit']); //Modifier un restaurant
Route::delete('/restaurants/{id}', [RestaurantController::class, 'delete']); //Supprimer un restaurant

//Menus
Route::get('/menus', [MenuController::class, 'getAll']); //Récupérer la liste des menus
Route::get('/menus/{id}', [MenuController::class, 'getByID']); //Récupérer le menu correspondant à l'id donné
Route::get('/restaurants/{id}/menus', [MenuController::class, 'getAllFromRestaurant']); //Récupérer les menus d'un restaurant
Route::post('/restaurants/{id}/menus', [MenuController::class, 'create']); //Créer un menu pour un restaurant
Route::put('/menus/{id}', [MenuController::class, 'edit']); //Modifier un menu
Route::delete('/menus/{id}', [MenuController::class, 'delete']); //Supprimer un menu

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});
