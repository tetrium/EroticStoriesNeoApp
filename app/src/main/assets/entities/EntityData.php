<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;
use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\conversation_category.sql

 */

class EntityData
{


     /**
      * @var int
      */
     public $entityId;

     /**
      * @var string
      */
     public $entityName;


     /**
      * @var string
      */

     public $idValue;

     /**
      * @var string
      */
     public $lastModificationDatetime;

     
     public static function getInstance($object): EntityData
     {
          $object = Common::stdClassToClass($object, "vanci_core\\entities\\EntityData");
          return $object;
     }
     function __construct()
     {
          
     }
}
