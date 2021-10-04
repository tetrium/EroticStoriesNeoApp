<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;
use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\conversation_category.sql

 */

class ConversationCategoryData
{


     /**
      * @var int
      */
     public $conversationCategoryId;

     /**
      * @var string
      */
     public $conversationCategoryName;


     /**
      * @var string
      */

     public $conversationCategoryImage64;

     /**
      * @var string
      */
     public $conversationCategoryImageUrl;

     
     public static function getInstance($object): ConversationCategoryData
     {
          $object = Common::stdClassToClass($object, "vanci_core\\entities\\ConversationCategoryData");
          return $object;
     }
     function __construct(int $conversationCategoryId = -1)
     {
          $globals = Globals::build();

  





          

          if ($conversationCategoryId > 0) {
               $imagePath = Common::getImagePath($conversationCategoryId, "conversation_category", 1);
               $this->conversationImage64 = '';

               if (!file_exists($imagePath)) {
                    $imageUrl = Common::getImageUrl(0, "conversation_category", 1); // $globals->serverResourcesUrl . 'images/conversation/0.png';
               } else {
                    $imageUrl = Common::getImageUrl($conversationCategoryId, "conversation_category", 1);
                    //$imageUrl = $globals->serverResourcesUrl . 'images/conversation/' . $conversationId . '.png';
               }


               $this->conversationCategoryImageUrl = $imageUrl;
          } else {

               $this->conversationCategoryId = -1;
               $this->conversationCategoryName = '';
               $this->conversationCategoryImage64 = '';
               //  $imageUrl = $globals->serverResourcesUrl . 'images/conversation/0.png';
               $imageUrl = Common::getImageUrl(0, "conversation_category", 0);
               $this->conversationCategoryImageUrl = $imageUrl;
          }
     }
}
