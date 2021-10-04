<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;
use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\catalog_error.sql

 */

class CatalogErrorData
{
    
     /**
      * @var int
      */
     public $catalogErrorId;

     /**
      * @var string
      */
     public $catalogErrorKeyword;


     /**
      * @var string
      */

     public $catalogErrorDescription;

 
     public static function getInstance($object): CatalogErrorData
     {
          $object = Common::stdClassToClass($object, "vanci_core\\entities\\CatalogErrorData");
          return $object;
     }
     function __construct(int $catalogErrorId = -1)
     {
       
     }
}
