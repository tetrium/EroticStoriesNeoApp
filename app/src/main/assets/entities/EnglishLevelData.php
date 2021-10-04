<?php

namespace vanci_core\entities;
use vanci_core\libs\Common;

use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\conversation_category.sql

 */

class EnglishLevelData
{


     /**
      * @var int
      */
     public $englishLevelId;

     /**
      * @var string
      */
     public $englishLevelName;

     /**
      * @var string
      */
      public $lastModificationDateTime;

      public static function getInstance($object): EnglishLevelData
      {
           $object = Common::stdClassToClass($object, "vanci_core\\entities\\EnglishLevelData");
           return $object;
      }
     function __construct()
     {
      
     }
}
