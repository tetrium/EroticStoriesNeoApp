<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;
use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\user_favorite_conversation.sql

 */

class UserFavoriteConversationCategoryData
{


     /**
      * @var int
      */
     public $userConversationSentenceAnnotationId;

     /**
      * @var string
      */
     public $userConversationSentenceAnnotationName;


     /**
      * @var int
      */

     public $entityId;

     /**
      * @var string
      */
     public $userConversationSentenceAnnotationDescription;

     
     public static function getInstance($object): UserFavoriteConversationCategoryData
     {
          $object = Common::stdClassToClass($object, "vanci_core\\entities\\UserFavoriteConversationCategoryData");
          return $object;
     }
     function __construct()
     {
          
     }
}
