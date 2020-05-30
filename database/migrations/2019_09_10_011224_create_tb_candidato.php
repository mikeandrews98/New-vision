<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateTbCandidato extends Migration
{
  public function up(){
    Schema::disableForeignKeyConstraints();

    Schema::create('tbCandidato', function(Blueprint $table){
      $table->increments('codCandidato');
      $table->string('nomeCandidato', 150);
      $table->string('cpfCandidato', 11)->unique();
      $table->date('dataNascimentoCandidato');
      $table->integer('codUsuario')->unsigned();
      $table->timestamps();
    });

    Schema::table('tbCandidato', function($table){
      $table->foreign('codUsuario')->references('codUsuario')->on('tbUsuario');
    });

    Schema::enableForeignKeyConstraints();
  }

  public function down(){
    Schema::disableForeignKeyConstraints();
    Schema::table('tbCandidato', function (Blueprint $table) {
        $table->dropForeign(['codUsuario']);
        $table->dropIfExists('tbCandidato');
      });
    Schema::enableForeignKeyConstraints();
  }
}
