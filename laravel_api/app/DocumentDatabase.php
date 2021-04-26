<?php

namespace App;

use Illuminate\Support\Facades\DB;

class DocumentDatabase
{
    function getDocuments()
    {
        $Documents = DB::table('menu')->get();
        return $Documents;
    }
}
