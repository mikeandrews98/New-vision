@extends('layouts.app')

@section('content')
<br>
<br>
<br>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Dashboard</div>

                <div class="card-body">
                    @if (session('status'))
                        <div class="alert alert-success" role="alert">

                        </div>
                    @endif


                    Você tem uma sessao
                    e seu redirecionamento funcionou!
                </div>
            </div>
        </div>
    </div>
</div>
@endsection